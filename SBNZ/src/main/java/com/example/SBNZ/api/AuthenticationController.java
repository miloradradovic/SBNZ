package com.example.SBNZ.api;

import com.example.SBNZ.dto.PersonToRegisterDTO;
import com.example.SBNZ.dto.UserLoginDTO;
import com.example.SBNZ.dto.UserTokenStateDTO;
import com.example.SBNZ.model.Admin;
import com.example.SBNZ.model.Authority;
import com.example.SBNZ.model.Person;
import com.example.SBNZ.model.User;
import com.example.SBNZ.security.TokenUtils;
import com.example.SBNZ.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private KieService kieService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    // Prvi endpoint koji pogadja korisnik kada se loguje.
    // Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
    @PostMapping("/log-in")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserLoginDTO authenticationRequest,
                                                       HttpServletResponse response) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));

        // Ubaci korisnika u trenutni security kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
        Person person = (Person) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(person.getUsername(), person.getId(), person.getAuthorities().get(0).getAuthority()); // prijavljujemo se na sistem sa email adresom

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new UserTokenStateDTO(jwt));
    }

    @PostMapping("/log-out")
    public ResponseEntity<?> logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person) authentication.getPrincipal();
        String username = person.getUsername();
        kieService.removeKieSession(username);
        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(null);
    }

    // U slucaju isteka vazenja JWT tokena, endpoint koji se poziva da se token osvezi
    @PostMapping(value = "/refresh")
    public ResponseEntity<UserTokenStateDTO> refreshAuthenticationToken(HttpServletRequest request) {

        String token = tokenUtils.getToken(request);
        String username = this.tokenUtils.getUsernameFromToken(token);
        Person person = (Person) this.userDetailsService.loadUserByUsername(username);

        if (this.tokenUtils.canTokenBeRefreshed(token, person.getLastPasswordResetDate())) {
            String refreshedToken = tokenUtils.refreshToken(token);
            int expiresIn = tokenUtils.getExpiredIn();

            return ResponseEntity.ok(new UserTokenStateDTO(refreshedToken));
        } else {
            UserTokenStateDTO userTokenState = new UserTokenStateDTO();
            return ResponseEntity.badRequest().body(userTokenState);
        }
    }

    // Endpoint za registraciju novog korisnika
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody PersonToRegisterDTO userRequest) throws Exception {

        User existUser = this.userService.findByUsername(userRequest.getUsername());
        Admin existAdmin = this.adminService.findByUsername(userRequest.getUsername());
        if (existUser != null || existAdmin != null) {
            return new ResponseEntity<>("Username or email already exists.", HttpStatus.BAD_REQUEST);
        }
        existUser = new User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getUsername(),
                passwordEncoder.encode(userRequest.getPassword()), true, userRequest.getAge());

        long role = 2;
        List<Authority> auth = authorityService.findById(role);
        existUser.setAuthorities(auth);

        User newUser = userService.registerUser(existUser);

        if(newUser == null){
            return new ResponseEntity<>("Username already exists.", HttpStatus.BAD_REQUEST);
        }
        userRequest.setId(newUser.getId());
        return new ResponseEntity<>(userRequest, HttpStatus.CREATED);
    }

}

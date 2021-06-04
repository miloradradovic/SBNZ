package com.example.SBNZ.service;

import com.example.SBNZ.model.Authority;
import com.example.SBNZ.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Authority> findById(Long id) {
        List<Authority> auths = new ArrayList<>();
        Authority auth = this.authorityRepository.findById(id).orElse(null);
        if(auth != null)
            auths.add(auth);
        return auths;
    }
}

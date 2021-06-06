import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LogIn, LogInModel } from 'app/model/login.model';
import {JwtHelperService} from '@auth0/angular-jwt';
import { LogInService } from 'app/services/log-in.service';
import { Router } from '@angular/router';
import { StorageService } from 'app/services/storage.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { MatSnackBar } from '@angular/material/snack-bar';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    data : Date = new Date();
    focus;
    focus1;


    form: FormGroup;
    error = '';
    private fb: FormBuilder;


    constructor(
        fb: FormBuilder,
        private logInService: LogInService,
        public router: Router,
        private storageService: StorageService,
        private spinnerService: NgxSpinnerService,
        private snackBar: MatSnackBar
      ) {
        this.fb = fb;
        this.form = this.fb.group({
          username: [null, [Validators.required, Validators.email]],
          password: [null, Validators.required]
        });
      }

    ngOnInit() {
        var body = document.getElementsByTagName('body')[0];
        body.classList.add('login-page');

        var navbar = document.getElementsByTagName('nav')[0];
        navbar.classList.add('navbar-transparent');
    }
    ngOnDestroy(){
        var body = document.getElementsByTagName('body')[0];
        body.classList.remove('login-page');

        var navbar = document.getElementsByTagName('nav')[0];
        navbar.classList.remove('navbar-transparent');
    }

    submit(): void {
        const logIn: LogIn = this.form.value;
        this.spinnerService.show();
        this.logInService.logIn(logIn).subscribe(
          result => {
            const jwt: JwtHelperService = new JwtHelperService();
            const info = jwt.decodeToken(result.accessToken);
            const role = info.role;
            const user = new LogInModel(info.username, result.accessToken ,info.id, info.role);
            localStorage.setItem('user', JSON.stringify(user));
            this.storageService.setStorageItem('user', JSON.stringify(user))
    
            this.snackBar.open('Successfully logged in!', 'Ok', {duration: 2000});
    
            if (role === 'ROLE_USER' || role === 'ROLE_ADMINISTRATOR') {
                this.spinnerService.hide();
                this.router.navigate(['/']);
            }


          },
          error => {
            this.snackBar.open('Bad credentials!', 'Ok', {duration: 2000});
            this.spinnerService.hide();
          }
        );
        

      }

}

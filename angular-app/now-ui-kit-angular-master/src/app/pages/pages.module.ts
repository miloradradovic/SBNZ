import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ComponentsModule } from 'app/components/components.module';
import { JwBootstrapSwitchNg2Module } from 'jw-bootstrap-switch-ng2';
import { NouisliderModule } from 'ng2-nouislider';
import { NgxSpinnerModule } from 'ngx-spinner';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';


@NgModule({
    imports: [
        ComponentsModule,
        ReactiveFormsModule,
        CommonModule,
        FormsModule,
        NgbModule,
        NouisliderModule,
        RouterModule,
        JwBootstrapSwitchNg2Module,
        HttpClientModule,
        NgxSpinnerModule
      ],
    declarations: [
        LandingPageComponent,
        LoginComponent,
        RegisterComponent
    ],
    exports:[  ]
})
export class PagesModule { }

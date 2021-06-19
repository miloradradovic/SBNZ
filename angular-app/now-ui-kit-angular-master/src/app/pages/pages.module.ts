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
import { TrainingComponent } from './training-page/training.component';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { DietComponent } from './diet-page/diet.component';
import { SearchDietComponent } from './search-diet/search-diet/search-diet.component';
import { MatCardModule } from '@angular/material/card';




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
        NgxSpinnerModule,
        MatSelectModule,
        MatInputModule,
        MatCheckboxModule,
        MatCardModule
      ],
    declarations: [
        LandingPageComponent,
        LoginComponent,
        RegisterComponent,
        TrainingComponent,
        DietComponent,
        SearchDietComponent
    ],
    exports:[  ]
})
export class PagesModule { }

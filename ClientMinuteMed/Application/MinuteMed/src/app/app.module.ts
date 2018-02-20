import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MinuteMedRouter } from './app.routes';
import {ButtonModule} from 'primeng/button';
import {ScheduleModule} from 'primeng/schedule';


import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ExamComponent } from './exam/exam.component';
import { SearchDmpComponent } from './searchdmp/searchdmp.component';
import { DmpComponent } from './dmp/dmp.component';
import { CreateexamComponent } from './createexam/createexam.component';
import { ConsultexamComponent } from './consultexam/consultexam.component';
import { DiagnosticComponent } from './diagnostic/diagnostic.component';
import { CreatediagnosticComponent } from './creatediagnostic/creatediagnostic.component';
import { ConsultdiagnosticComponent } from './consultdiagnostic/consultdiagnostic.component';
import { PosologieComponent } from './posologie/posologie.component';
import { ConsultposologieComponent } from './consultposologie/consultposologie.component';
import { PrescriptionComponent } from './prescription/prescription.component';
import { ConsultprescriptionComponent } from './consultprescription/consultprescription.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LeftnavbardoctorComponent } from './leftnavbardoctor/leftnavbardoctor.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    ExamComponent,
    SearchDmpComponent,
    DmpComponent,
    CreateexamComponent,
    ConsultexamComponent,
    DiagnosticComponent,
    CreatediagnosticComponent,
    ConsultdiagnosticComponent,
    PosologieComponent,
    ConsultposologieComponent,
    PrescriptionComponent,
    ConsultprescriptionComponent,
    NavBarComponent,
    LeftnavbardoctorComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    MinuteMedRouter,
    ButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

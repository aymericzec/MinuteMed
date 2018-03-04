import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MinuteMedRouter } from './app.routes';
import {ButtonModule} from 'primeng/button';
import {TreeModule} from 'primeng/tree';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';

import {
  HttpClient, HttpRequest, HttpResponse, HTTP_INTERCEPTORS,
  HttpHeaders, HttpParams, HttpHandler, HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ExamComponent } from './exam/exam.component';
import { SearchDmpComponent } from './searchdmp/searchdmp.component';
import { DmpComponent } from './dmp/dmp.component';
import { CreateexamComponent } from './createexam/createexam.component';
import { CreatedmpComponent } from './createdmp/createdmp.component';
import { ConsultexamComponent } from './consultexam/consultexam.component';
import { DiagnosticComponent } from './diagnostic/diagnostic.component';
import { CreatediagnosticComponent } from './creatediagnostic/creatediagnostic.component';
import { ConsultdiagnosticComponent } from './consultdiagnostic/consultdiagnostic.component';
import { PosologieComponent } from './posologie/posologie.component';
import { ConsultposologieComponent } from './consultposologie/consultposologie.component';
import { PrescriptionComponent } from './prescription/prescription.component';
import { ConsultprescriptionComponent } from './consultprescription/consultprescription.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import {TableModule} from 'primeng/table';


import { AuthenticationRESTEndpointService, StaffRESTEndpointService, ArborescenceRESTEndpointService,
  MedicalRecordsRESTEndpointService, SpecializationsRESTEndpointService } from './api/services';
import { ApiConfiguration } from './api/api-configuration';
import { AuthService } from './auth.service';
import { AuthGuardService } from './auth.guard.service';
import { TestComponent } from './test/test.component';
import { LeftbarComponent } from './leftbar/leftbar.component';
import {TokenInterceptor} from './token.interceptor';
import {JwtInterceptor} from './jwt.interceptor';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    ExamComponent,
    SearchDmpComponent,
    DmpComponent,
    CreatedmpComponent,
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
    TestComponent,
    LeftbarComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    MinuteMedRouter,
    ButtonModule,
    HttpClientModule,
    TableModule,
    TreeModule,
  ],
  providers: [ApiConfiguration, AuthService, AuthGuardService, AuthenticationRESTEndpointService,
    StaffRESTEndpointService, ArborescenceRESTEndpointService, MedicalRecordsRESTEndpointService,
    SpecializationsRESTEndpointService,
  {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  },
  {
    provide: HTTP_INTERCEPTORS,
    useClass: JwtInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }


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
import { SearchExamsComponent } from './search-exams/search-exams.component';
import { SearchDmpComponent } from './searchdmp/searchdmp.component';
import { DmpComponent } from './dmp/dmp.component';
import { CreatedmpComponent } from './createdmp/createdmp.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import {TableModule} from 'primeng/table';
import {DataViewModule} from 'primeng/dataview';

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
import { LeftbarinfoComponent } from './leftbarinfo/leftbarinfo.component';
import { ConsultExamComponent } from './consult-exam/consult-exam.component';
import { CreateExamComponent } from './create-exam/create-exam.component';
import { CreateDiagnosticComponent } from './create-diagnostic/create-diagnostic.component';
import { SearchDiagnosticsComponent } from './search-diagnostics/search-diagnostics.component';
import { ConsultDiagnosticComponent } from './consult-diagnostic/consult-diagnostic.component';
import { SearchPrescriptionsComponent } from './search-prescriptions/search-prescriptions.component';
import { ConsultPrescriptionComponent } from './consult-prescription/consult-prescription.component';
import { SearchDosagesComponent } from './search-dosages/search-dosages.component';
import { ConsultDosageComponent } from './consult-dosage/consult-dosage.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SearchExamsComponent,
    SearchDmpComponent,
    DmpComponent,
    CreatedmpComponent,
    NavBarComponent,
    TestComponent,
    LeftbarComponent,
    PageNotFoundComponent,
    LeftbarinfoComponent,
    ConsultExamComponent,
    CreateExamComponent,
    CreateDiagnosticComponent,
    SearchDiagnosticsComponent,
    ConsultDiagnosticComponent,
    SearchPrescriptionsComponent,
    ConsultPrescriptionComponent,
    SearchDosagesComponent,
    ConsultDosageComponent,
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
    DataViewModule
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


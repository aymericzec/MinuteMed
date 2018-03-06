import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { TestComponent } from './test/test.component';
import { LoginComponent } from './login/login.component';
import { AuthGuardService } from './auth.guard.service';
import { SearchDmpComponent } from './searchdmp/searchdmp.component';
import { DmpComponent } from './dmp/dmp.component';
import { CreatedmpComponent } from './createdmp/createdmp.component';
import { CreateExamComponent } from './create-exam/create-exam.component';
import { ConsultExamComponent } from './consult-exam/consult-exam.component';
import { SearchDiagnosticsComponent } from './search-diagnostics/search-diagnostics.component';
import { CreateDiagnosticComponent } from './create-diagnostic/create-diagnostic.component';
import { ConsultDiagnosticComponent } from './consult-diagnostic/consult-diagnostic.component';
import { SearchDosagesComponent } from './search-dosages/search-dosages.component';
import { ConsultDosageComponent } from './consult-dosage/consult-dosage.component';
import { SearchPrescriptionsComponent } from './search-prescriptions/search-prescriptions.component';
import { ConsultPrescriptionComponent } from './consult-prescription/consult-prescription.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SearchExamsComponent } from './search-exams/search-exams.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', canActivate: [AuthGuardService], pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuardService]},
  { path: 'searchdmp', component: SearchDmpComponent, canActivate: [AuthGuardService] },
  { path: 'record/:id', component: DmpComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/exams', component: SearchExamsComponent, canActivate: [AuthGuardService]},
  { path: 'createdmp', component: CreatedmpComponent, canActivate: [AuthGuardService] },
  { path: 'record/:id/createexam', component: CreateExamComponent, canActivate: [AuthGuardService] },
  { path: 'record/:id/exams/:idExam', component: ConsultExamComponent, canActivate: [AuthGuardService] },
  { path: 'record/:id/diagnostics', component: SearchDiagnosticsComponent, canActivate: [AuthGuardService] },
  { path: 'record/:id/creatediagnostic', component: CreateDiagnosticComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/diagnostics/:idDiagnostic', component: ConsultDiagnosticComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/dosages', component: SearchDosagesComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/dosages/:idPosologie', component: ConsultDosageComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/prescriptions', component: SearchPrescriptionsComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/prescriptions/:idPrescription', component: ConsultPrescriptionComponent, canActivate: [AuthGuardService]},
  { path: 'test', component: TestComponent, canActivate: [AuthGuardService]},
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class MinuteMedRouter { }

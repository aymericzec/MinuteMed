import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { TestComponent } from './test/test.component';
import { LoginComponent } from './login/login.component';
import { AuthGuardService } from './auth.guard.service';
import { SearchDmpComponent } from './searchdmp/searchdmp.component';
import { DmpComponent } from './dmp/dmp.component';
import { ExamComponent } from './exam/exam.component';
import { CreatedmpComponent } from './createdmp/createdmp.component';
import { CreateexamComponent } from './createexam/createexam.component';
import { ConsultexamComponent } from './consultexam/consultexam.component';
import { DiagnosticComponent } from './diagnostic/diagnostic.component';
import { CreatediagnosticComponent } from './creatediagnostic/creatediagnostic.component';
import { ConsultdiagnosticComponent } from './consultdiagnostic/consultdiagnostic.component';
import { PosologieComponent } from './posologie/posologie.component';
import { ConsultposologieComponent } from './consultposologie/consultposologie.component';
import { PrescriptionComponent } from './prescription/prescription.component';
import { ConsultprescriptionComponent } from './consultprescription/consultprescription.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', canActivate: [AuthGuardService], pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuardService]},
  { path: 'searchdmp', component: SearchDmpComponent, canActivate: [AuthGuardService] },
  { path: 'record/:id', component: DmpComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/exams', component: ExamComponent, canActivate: [AuthGuardService]},
  { path: 'createdmp', component: CreatedmpComponent, canActivate: [AuthGuardService] },
  { path: 'record/:id/createexam', component: CreateexamComponent, canActivate: [AuthGuardService] },
  { path: 'record/:id/exams/:idExam', component: ConsultexamComponent, canActivate: [AuthGuardService] },
  { path: 'record/:id/diagnostics', component: DiagnosticComponent, canActivate: [AuthGuardService] },
  { path: 'creatediagnostic', component: CreatediagnosticComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/diagnostics/:idDiagnostic', component: ConsultdiagnosticComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/posologies', component: PosologieComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/posologies/:idPosologie', component: ConsultposologieComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/prescriptions', component: PrescriptionComponent, canActivate: [AuthGuardService]},
  { path: 'record/:id/prescriptions/:idPrescription', component: ConsultprescriptionComponent, canActivate: [AuthGuardService]},
  { path: 'test', component: TestComponent, canActivate: [AuthGuardService]},
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class MinuteMedRouter { }

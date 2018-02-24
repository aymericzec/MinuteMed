import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AuthGuardService } from './auth.guard.service';
import { SearchDmpComponent } from './searchdmp/searchdmp.component';
import { DmpComponent } from './dmp/dmp.component';
import { ExamComponent } from './exam/exam.component';
import { CreateexamComponent } from './createexam/createexam.component';
import { ConsultexamComponent } from './consultexam/consultexam.component';
import { DiagnosticComponent } from './diagnostic/diagnostic.component';
import { CreatediagnosticComponent } from './creatediagnostic/creatediagnostic.component';
import { ConsultdiagnosticComponent } from './consultdiagnostic/consultdiagnostic.component';
import { PosologieComponent } from './posologie/posologie.component';
import { ConsultposologieComponent } from './consultposologie/consultposologie.component';
import { PrescriptionComponent } from './prescription/prescription.component';
import { ConsultprescriptionComponent } from './consultprescription/consultprescription.component';

const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuardService] },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuardService]},
  { path: 'searchdmp', component: SearchDmpComponent },
  { path: 'dmp', component: DmpComponent},
  { path: 'exam', component: ExamComponent},
  { path: 'createexam', component: CreateexamComponent },
  { path: 'consultexam', component: ConsultexamComponent },
  { path: 'diagnostic', component: DiagnosticComponent },
  { path: 'creatediagnostic', component: CreatediagnosticComponent},
  { path: 'consultdiagnostic', component: ConsultdiagnosticComponent},
  { path: 'posologie', component: PosologieComponent},
  { path: 'consultposologie', component: ConsultposologieComponent},
  { path: 'prescription', component: PrescriptionComponent},
  { path: 'consultprescription', component: ConsultprescriptionComponent},
//  { path: 'ratings/:id', component: VoteComponent, canActivate: [AuthGuardService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class MinuteMedRouter { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AuthGuardService } from './auth.guard.service';

const routes: Routes = [
//  { path: 'rooms', component: VenueComponent },
//  { path: 'sessions', component: ScheduleComponent },
//  { path: 'sessions/:id', component: ScheduledetailsComponent },
//  { path: 'speakers/:id', component: SpeakerDetailComponent },
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
//  { path: 'attendees', component : AttendeeComponent},
//  { path: 'ratings/:id', component: VoteComponent, canActivate: [AuthGuardService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class MinuteMedRouter { }

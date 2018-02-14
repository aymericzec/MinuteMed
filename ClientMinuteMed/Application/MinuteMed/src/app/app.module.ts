import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MinuteMedRouter } from './app.routes';


import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ExamComponent } from './exam/exam.component';
import { DmpComponent } from './dmp/dmp.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    ExamComponent,
    DmpComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    MinuteMedRouter,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

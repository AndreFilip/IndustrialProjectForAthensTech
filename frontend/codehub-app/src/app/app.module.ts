import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


import { AppComponent } from './app.component';
import { NavbarComponent } from './home/navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { CareerComponent } from './home/navbar/career/career.component';
import { LearnComponent } from './home/navbar/learn/learn.component';
import { TheProgressComponent } from './home/navbar/learn/the-progress/the-progress.component';
import { ProgramsComponent } from './home/navbar/learn/programs/programs.component';
import { AboutUsComponent } from './home/navbar/about-us/about-us.component';
import { PhilosophyComponent } from './home/navbar/about-us/philosophy/philosophy.component';
import { TeamComponent } from './home/navbar/about-us/team/team.component';
import { MyaccountComponent } from './home/navbar/myaccount/myaccount.component';
import { LoginComponent } from './home/navbar/myaccount/login/login.component';
import { SignupComponent } from './home/navbar/myaccount/signup/signup.component';
import { ContactUsComponent } from './home/navbar/myaccount/contact-us/contact-us.component';
import { AppRoutingModule } from './app-routing.module';
import { InstructorsComponent } from './home/navbar/learn/instructors/instructors.component';
import { HttpClientModule }    from '@angular/common/http';
import {UserService} from "./user.service";


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    CareerComponent,
    LearnComponent,
    TheProgressComponent,
    ProgramsComponent,
    AboutUsComponent,
    PhilosophyComponent,
    TeamComponent,
    MyaccountComponent,
    LoginComponent,
    SignupComponent,
    ContactUsComponent,
    InstructorsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule

  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }

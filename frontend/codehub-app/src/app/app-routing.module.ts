import { NgModule } from '@angular/core';
import {Routes, RouterModule, Router} from '@angular/router';

import { HomeComponent } from './home/home.component';
import { CareerComponent } from './home/navbar/career/career.component';
import { ProgramsComponent } from './home/navbar/learn/programs/programs.component';
import { TheProgressComponent } from './home/navbar/learn/the-progress/the-progress.component';
import { ContactUsComponent } from './home/navbar/myaccount/contact-us/contact-us.component';
import { LoginComponent } from './home/navbar/myaccount/login/login.component';
import { SignupComponent } from './home/navbar/myaccount/signup/signup.component';
import { PhilosophyComponent } from './home/navbar/about-us/philosophy/philosophy.component';
import { TeamComponent } from './home/navbar/about-us/team/team.component';
import { InstructorsComponent } from './home/navbar/learn/instructors/instructors.component';
import { AdminComponent } from './home/navbar/admin/admin.component';
import { JobPostsComponent } from './home/navbar/admin/job-posts/job-posts.component';
import { ApplicantsComponent } from './home/navbar/admin/applicants/applicants.component';
import { MyprofileComponent } from './home/navbar/myaccount/myprofile/myprofile.component';


const appRoutes: Routes = [
  {path: '' , redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'career', component: CareerComponent},
  {path: 'programs', component: ProgramsComponent},
  {path: 'the-progress', component: TheProgressComponent},
  {path: 'our-philosophy', component: PhilosophyComponent},
  {path: 'our-team', component: TeamComponent},
  {path: 'our-instructors', component: InstructorsComponent},
  {path: 'contact-us', component: ContactUsComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'job-posts', component: JobPostsComponent},
  {path: 'applicants', component: ApplicantsComponent},
  {path: 'myprofile', component: MyprofileComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}

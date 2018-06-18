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
import { MyprofileComponent } from './home/navbar/myaccount/myprofile/myprofile.component';
import { AdminComponent } from './home/admin/admin.component';
import { UsersComponent } from './home/admin/users/users.component';
import { JobPostsComponent } from './home/admin/job-posts/job-posts.component';
import { ArticlesComponent } from './home/admin/articles/articles.component';
import { EditProfileComponent } from './home/navbar/myaccount/edit-profile/edit-profile.component';
import { CareerdetailComponent } from './home/navbar/careerdetail/careerdetail.component';

import {AuthGuard} from './auth.guard';


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
  {path: 'myprofile', component: MyprofileComponent, canActivate: [AuthGuard] },
  {path: 'admin', component: AdminComponent, canActivate: [AuthGuard]},
  {path: 'admin-users', component: UsersComponent, canActivate: [AuthGuard]},
  {path: 'admin-jobs-post', component: JobPostsComponent, canActivate: [AuthGuard]},
  {path: 'admin-articles-post', component: ArticlesComponent, canActivate: [AuthGuard]},
  {path: 'edit-profile', component: EditProfileComponent, canActivate: [AuthGuard]},
  {path: 'careerdetail/:jobtitle', component: CareerdetailComponent },
  {path: '**' , redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}

import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from '../../../../user.model';
import { NgForm } from '@angular/forms';
import { UserService } from '../../../../user.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  user: User;

  constructor(private http: HttpClient, private userService: UserService, private router: Router) { }

  ngOnInit() {      
    // for testing purposes  
    this.user = {  
      firstName: "dasda",
        lastName: "dasda",
        userTechstack: ["java","javascript"],
        linkedinPath: "dasda",
        phoneNumber: "6971234567",
        email: "dasda@asd.gr",
        password: "dasda",
        roleName: "roleName",
        country: "GR",
        dateCreated : new Date,
        latestLogin: new Date,
        isActive: true,
        stackOverflowPath: "dasda",
        gitPath: "dasda",
        username: "dasda",
    };         

  }

  submitChanges(form: NgForm) {
    const changedUser = new User( form.value.firstName, form.value.lastName, form.value.techStack, form.value.linkedinLink, form.value.phoneNumber,
      form.value.email, null /*password*/, null  /*role*/, 'GR', null  /*date created*/, new Date() /*latest login*/, true,  form.value.stackoverflowLink,  form.value.githubLink, form.value.username);

    console.log(changedUser);

    this.userService.editProfile(changedUser).subscribe(
      response => {console.log(response); this.router.navigate(['/myprofile'])},
      err => {console.log(err); alert('Something went wrong and profile did not change.'); this.router.navigate(['/myprofile'])}
      );
  }


}

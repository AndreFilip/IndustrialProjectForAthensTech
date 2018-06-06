import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from '../../../../user.model';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  user: User;

  constructor(private http: HttpClient) { }

  ngOnInit() {    
    // userService should know user logically?
    // this.user = this.userService.user;

    // for testing purposes  
    this.user = {  
      firstName: "dasda",
        lastName: "dasda",
        techStack: ["java","javascript"],
        linkedInLink: "dasda",
        phoneNumber: "6971234567",
        email: "dasda@asd.gr",
        password: "dasda",
        roleName: "dasda",
        countryIsoCode: "GR",
        dateCreated : new Date,
        latestLogin: new Date,
        isActive: true,
        stackOverflowLink: "dasda",
        githubLink: "dasda",
        username: "dasda",
    };  


  }



  submitChanges(form: NgForm) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json'); 
  
    // I put "null" because these do not change. George should not GET these.
    const changedUser = new User( form.value.firstName, form.value.lastName, form.value.techStack, form.value.linkedinLink, form.value.phoneNumber,
      form.value.email, null /*password*/, null  /*role*/, 'GR', null  /*date created*/, new Date() /*latest login*/, true,  form.value.stackoverflowLink,  form.value.githubLink, form.value.username);

    console.log(changedUser);

    // PUT implement in backend ?
    return this.http.put('http://localhost:8088/api/userService/ e.g. changeUserInfo',  JSON.stringify(changedUser),
      { headers: headers}).subscribe(response => {
      console.log(response); }
      );
  }


}

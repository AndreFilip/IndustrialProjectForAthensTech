import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../../../../user.model';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../../../../user.service';
import { Location } from '@angular/common';


@Component({
  selector: 'app-myprofile',
  templateUrl: './myprofile.component.html',
  styleUrls: ['./myprofile.component.css']
})
export class MyprofileComponent implements OnInit {
  user: User;

  constructor(private userService: UserService) { }

  ngOnInit() {
    // userService should know user logically?
    // this.user = this.userService.user;

    // for testing purposes
    this.user =  {
      firstName: "dasda",
        lastName: "dasda",
        techStack: ["dasda", "1354"],
        linkedInLink: "dasda",
        phoneNumber: "dasda",
        email: "dasda",
        password: "dasda",
        roleName: "dasda",
        countryIsoCode: "dasda",
        dateCreated : new Date,
        latestLogin: new Date,
        isActive: true,
        stackOverflowLink: "dasda",
        githubLink: "dasda",
        username: "dasda",
      }
    
  }

  editProfile() {
  }    


}



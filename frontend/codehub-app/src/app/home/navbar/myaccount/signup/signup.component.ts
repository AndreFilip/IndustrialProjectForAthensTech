import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from "../../../../user.model";
import {RequestOptions} from "@angular/http";


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
private dateCreated;
private Url = 'http://localhost:8088/api/userService/register';  // URL to web api


  user = {
    firstName: '',
    lastName: '',
    techStack: '',
    profileLink: '',
    phoneNumber: '',
    email: '',
    password: '',
    roleName: 'Candidate',
    countryIsoCode: 'GR',
    dateCreated : new Date(),
    latestLogin: new Date(),
    isActive: true
  };

  constructor(private http: HttpClient) {

  }


  ngOnInit() {
  }

  onRegisterUser(form: NgForm) {
    const headers = new HttpHeaders().set("Content-Type", "application/json");
    const newUser = new User( form.value.firstName, form.value.lastName, form.value.techStack, form.value.profileLink, form.value.phoneNumber,
    form.value.email, form.value.password, "Candidate", "GR", new Date(), new Date(), true);
    console.log(newUser);
    return this.http.post('http://localhost:8088/api/userService/register',  JSON.stringify(newUser),
      { headers: headers}).subscribe(response =>{
      console.log(response);}
      );
  }
}

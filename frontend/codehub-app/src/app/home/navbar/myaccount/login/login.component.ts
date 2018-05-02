import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 user = {
   userName: '',
   password: ''
 };

  constructor() { }

  ngOnInit() {
  }

  onLoginUser(form: NgForm) {
  this.user.userName = form.value.userName;
  this.user.password = form.value.password;

    console.log(this.user);
  }

}

import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {UserService} from '../../../../user.service';
import { Router} from '@angular/router';
import {AuthService} from "../../../../auth.service";
import {TokenStorage} from "../../../../token.storage";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 user = {
   username: '',
   password: ''
 };

  constructor(private router: Router, private authService: AuthService, private token: TokenStorage) {
  }

  // constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  // onLoginUser(form: NgForm) {
  //   this.user.username = form.value.userName;
  //   this.user.password = form.value.password;
  //
  //   console.log(this.user);
  //
  //   this.userService.loginUser(this.user).subscribe(
  //     response => {
  //                 console.log(response);
  //                 if (response.status == 200) {
  //                   localStorage.setItem('token', response.token);
  //                   alert('You successfully logged in.');
  //                   this.router.navigate(['/'])
  //                 }
  //                 } ,
  //     err =>      {
  //                 console.log(err);
  //                 alert('You did not log in. Something went wrong.');
  //                 }
  //   );
  //
  // }

  onLoginUser(form: NgForm): void {
    this.authService.attemptAuth(form.value.userName, form.value.password).subscribe(
      data => {
        console.log(data);
        this.token.saveToken(data.token);
        this.router.navigate(['user']);
      }
    );
  }

}

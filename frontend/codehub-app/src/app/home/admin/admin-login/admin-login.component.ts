import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {Router} from '@angular/router';
import { AdminService } from './admin.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  admin = {
    userName: '',
    password: ''
  };
  secureAdmin = {
    userName: 'Admin',
    password: 'password'
  };

  constructor(private router: Router, private adminService: AdminService) {}

  ngOnInit() {}

  onLoginAdmin(form: NgForm) {
    console.log(this.adminService.logedInAdmin);    
    this.admin.userName = form.value.userName;
    this.admin.password = form.value.password;
    if (this.admin.userName == this.secureAdmin.userName && this.admin.password == this.secureAdmin.password) {
      // console.log(this.adminService.logedInAdmin);
      this.adminService.logedInAdmin.next(true);
      this.router.navigate(['/admin-dashboard']);
    } else {
      console.log(this.admin);

      alert('Wrong credentials');
    }
  }
}

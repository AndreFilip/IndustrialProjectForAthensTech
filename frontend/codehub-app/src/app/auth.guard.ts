import { Injectable } from '@angular/core';
import { CanActivate, Router} from '@angular/router';
import {UserService} from './user.service';
import { AdminService } from './home/admin/admin-login/admin.service';



@Injectable()
export class AuthGuard implements CanActivate {

  constructor (private adminService: AdminService, private router: Router) {}

  canActivate(): boolean {
    if (this.adminService.logedInAdmin) {
      return true
    } else {
      alert("Log in/Sign up in order to see this page.");
      this.router.navigate(['/admin'])
      return false
    }

  }

}

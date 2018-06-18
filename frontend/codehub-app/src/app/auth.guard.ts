import { Injectable } from '@angular/core';
import { CanActivate, Router} from '@angular/router';
import {UserService} from './user.service';


@Injectable()
export class AuthGuard implements CanActivate {

  constructor (private userService: UserService, private router: Router) {}

  canActivate(): boolean {
    if (this.userService.loggedIn()) {
      return true
    } else {
      alert("Log in/Sign up in order to see this page.");
      this.router.navigate(['/login'])
      return false
    }

  }

}
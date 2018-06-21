import { Injectable } from '@angular/core';
import { AdminService } from './home/admin/admin-login/admin.service';


const TOKEN_KEY = 'AuthToken';

@Injectable()
export class TokenStorage {

  constructor(private adminService: AdminService) { }

  public signOut() {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.clear();
    this.adminService.logedInAdmin.next(false);
    alert("You have logged out.");
  }

  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY,  token);
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public getTokenBoolean(): boolean {
    return !!sessionStorage.getItem(TOKEN_KEY);
  }
}

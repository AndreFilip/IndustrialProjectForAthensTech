import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import {UserService} from '../../user.service';
import {TokenStorage} from '../../token.storage';
import { AdminService } from '../admin/admin-login/admin.service';



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  logo: String;

  @Input() doLoginStatus: boolean;
  @Output() doLogin = new EventEmitter;

  constructor(private tokenStorage: TokenStorage, private adminService: AdminService) {    
    this.logo = '/assets/images/logo.png'
   }

  ngOnInit() {

  }

  onDoLogin() {
    this.doLogin.emit();
  }

  

}

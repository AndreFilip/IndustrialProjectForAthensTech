import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import {UserService} from '../../user.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  logo: String;

  @Input() doLoginStatus: boolean;
  @Output() doLogin = new EventEmitter;

  constructor(private userService: UserService) {    
    this.logo = '/assets/images/logo.png'
   }

  ngOnInit() {

  }

  onDoLogin() {
    this.doLogin.emit();
  }

  

}

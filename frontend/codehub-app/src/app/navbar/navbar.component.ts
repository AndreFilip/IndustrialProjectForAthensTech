import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Input() doLoginStatus: boolean;
  @Output() doLogin = new EventEmitter;

  constructor() { }

  ngOnInit() {
  }

  onDoLogin() {
    this.doLogin.emit();
  }

}

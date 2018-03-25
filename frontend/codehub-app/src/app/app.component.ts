import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  doLoginStatus = false;

  doLogin() {
    console.log("LOGIN REQUESTED!");
    this.doLoginStatus = true;
    console.log(this.doLoginStatus);

  }

  onLoginUser(username: string, password: string) {

  }


}

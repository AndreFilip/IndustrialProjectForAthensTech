import { Component, OnInit } from '@angular/core';
import { User } from '../../../../user.model';
import { UserService } from '../../../../user.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-myprofile',
  templateUrl: './myprofile.component.html',
  styleUrls: ['./myprofile.component.css']
})

export class MyprofileComponent implements OnInit {
  user: any;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() { 
    this.user = {  
        firstName: "firstName",
        lastName: "lastName",
        // userTechstack: ["java","javascript"],
        linkedinPath: "linkedinPath",
        phoneNumber: "6971234567",
        email: "email@email.gr",
        password: "password",
        // roleName: "roleName",
        country: "GR",
        dateCreated : new Date,
        latestLogin: new Date,
        isActive: true,
        stackOverflowPath: "dasda",
        gitPath: "dasda",
        username: "dasda",
    };           
  }

  // getUser(theEmail: string) {
  //   this.userService.getUser(theEmail).subscribe(
  //     response => {console.log(response); this.user = response; },
  //     err => {
  //       console.log(err); 
  //       this.user = new User( "dasda", "dasda", ["java","javascript"], "dasda", "6971234567", "email", null, null, 'GR', null, null, true,  "dasda",  "dasda", "dasda");           
  //       alert('Something went wrong and user was not get.');  
  //     }
  //     );
  // }


}



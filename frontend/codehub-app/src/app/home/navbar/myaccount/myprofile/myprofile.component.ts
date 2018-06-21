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
        linkedinPath: "linkedinPath",
        phoneNumber: "6971234567",
        email: "email@email.gr",
        password: "password",
        country: "GR",
        dateCreated : new Date,
        latestLogin: new Date,
        isActive: true,
        stackOverflowPath: "stackOverflowPath",
        gitPath: "gitPath",
        username: "username"
    };           
  }


}



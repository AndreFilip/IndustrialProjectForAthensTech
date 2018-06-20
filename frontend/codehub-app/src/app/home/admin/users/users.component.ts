import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../user.service';
import { User } from '../../../user.model';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) { }

  ngOnInit() {
  this.userService.getUsers().subscribe(x => this.users = x , error => { 
                                                      this.users =  [{
                                                                    email: "email",
                                                                    username: "username",
                                                                    password: "password",
                                                                    firstName: "firstName",
                                                                    lastName: "lastName",
                                                                    countryIsoCode: "countryIsoCode",
                                                                    isActive: true,
                                                                    dateCreated : new Date(),
                                                                    latestLogin: new Date(),  
                                                                    phoneNumber: "phoneNumber",
                                                                    status: "status",
                                                                    internalComments: "internalComments",
                                                                    cvPath: "cvPath",
                                                                    avatarPath: "avatarPath",
                                                                    linkedinPath: "linkedinPath",
                                                                    stackOverflowPath: "stackOverflowPath",
                                                                    gitPath: "gitPath"
                                                                    }];
                                                                    }
     );
  }                                                          


}

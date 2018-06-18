import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from '../../../../user.model';
import { NgForm } from '@angular/forms';
import { UserService } from '../../../../user.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  user = {};

  constructor(private http: HttpClient, private userService: UserService, private router: Router) { }

  ngOnInit() {      
    // for testing purposes  
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

  submitChanges(form: NgForm) {
    const changedUser = new User (form.value.email, form.value.username, form.value.password, form.value.firstName, form.value.lastName, form.value.country, true, new Date(), new Date(),
    form.value.phoneNumber, 'status', 'internalComments', 'cvPath', 'avatarPath', form.value.linkedinLink, form.value.stackoverflowLink,  form.value.githubLink);   

    console.log(changedUser);

    this.userService.editProfile(changedUser).subscribe(
      response => {console.log(response); this.router.navigate(['/myprofile'])},
      err => {console.log(err); alert('Something went wrong and profile did not change.'); this.router.navigate(['/myprofile'])}
      );
  }


}

import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {User} from '../../../../user.model';
import {UserService} from '../../../../user.service';
import { Router} from '@angular/router';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) {  }

  ngOnInit() {  }

  onRegisterUser(form: NgForm) {
    const newUser = new User (form.value.email, form.value.username, form.value.password, form.value.firstName, form.value.lastName, form.value.country, true, new Date(), new Date(),
    form.value.phoneNumber, 'status', 'internalComments', 'cvPath', 'avatarPath', form.value.linkedinLink, form.value.stackoverflowLink,  form.value.githubLink);

    console.log(newUser);

    this.userService.registerUser(newUser).subscribe(
      response => { 
                    console.log(response);
                    if (response.status >= 200 && response.status <= 299) {
                      localStorage.setItem('token', response.token);
                      alert('You successfully signed in.');         
                      this.router.navigate(['/'])
                    }   
                  } ,
      err =>      {
                  console.log(err);
                  alert('You did not sign in. Something went wrong.'); 
                  }
    );

    
  }
}

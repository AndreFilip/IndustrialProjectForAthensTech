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
    const newUser = new User( form.value.firstName, form.value.lastName, form.value.techStack, form.value.linkedinLink, form.value.phoneNumber,
    form.value.email, form.value.password, 'candidate', 'GR', new Date(), new Date(), true,  form.value.stackoverflowLink,  form.value.githubLink, form.value.username);

    console.log(newUser);

    this.userService.registerUser(newUser).subscribe(
      response => { 
                  console.log(response);
                  localStorage.setItem('token', response.token);
                  alert('You successfully signed in.');         
                  this.router.navigate(['/'])
                  } ,
      err =>      {
                  console.log(err);
                  alert('You did not sign in. Something went wrong.'); 
                  }
    );

    
  }
}

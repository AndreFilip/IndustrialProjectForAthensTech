import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {User} from '../../../../user.model';
import {UserService} from '../../../../user.service';
import { Router} from '@angular/router';
import {Country} from '../../../../country';
import {JobpostsService} from '../../../../jobposts.service';



@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent implements OnInit {
  countries: Country[];
  stacks: any[];

  constructor(private userService: UserService, private jobpostsService: JobpostsService,private router: Router) {  }

  ngOnInit() {  
    this.getAllCountries();  
    this.getAllStacks();  
  }

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

  getAllCountries() {
    this.jobpostsService.getAllCountries().subscribe( response => {console.log(response); this.countries = response},
    err =>      {
                console.log(err);
                // alert("Unsuccessfully fetched teckstacks and hardcode-generated.");
                this.countries = [ {
                  isoCode: "GR",
                  nameCapital: "nameCapital",
                  nameView:"Greece-not from server",
                  isoCode3:"isoCode3",
                  numCode:"numCode",
                  phoneCode:"phoneCode"
                },
                {
                  isoCode: "AU",
                  nameCapital: "nameCapital",
                  nameView:"Australia",
                  isoCode3:"isoCode3",
                  numCode:"numCode",
                  phoneCode:"phoneCode"
                }    
                                  ];
            
                });
  }



  getAllStacks() {
    this.jobpostsService.getAllStacks().subscribe( response => {console.log(response); this.stacks = response}, 
    err =>      {
                console.log(err);
                // alert("Unsuccessfully fetched teckstacks and hardcode-generated.");
                this.stacks = [    {stack:"randomStack"},
                                   {stack:"Error."},
                                   {stack:"Not fetching stacks"},
                                   {stack:"from server"}
                                  ];
            
                });
  }






}

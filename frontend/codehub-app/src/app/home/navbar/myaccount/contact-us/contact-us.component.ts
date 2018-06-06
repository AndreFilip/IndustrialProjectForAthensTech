import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  // info@codehub.gr


  // onSend(form: NgForm) {
  //   const headers = new HttpHeaders().set('Content-Type', 'application/json');
    
  //   form.value.telephone

  //   const newUser = new User( form.value.firstName, form.value.lastName, form.value.techStack, form.value.linkedinLink, form.value.phoneNumber,
  //   form.value.email, form.value.password, 'Candidate', 'GR', new Date(), new Date(), true,  form.value.stackoverflowLink,  form.value.githubLink, form.value.username);

  //   console.log(newUser);

  //   return this.http.post('http://localhost:8088/api/userService/register',  JSON.stringify(newUser),
  //     { headers: headers}).subscribe(response => {
  //     console.log(response); }
  //     );
  // }
}

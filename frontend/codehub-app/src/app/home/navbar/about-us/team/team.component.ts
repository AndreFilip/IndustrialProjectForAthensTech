import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
  velkos: string;
  nikolako: string;


  constructor() {

    this.velkos = '/assets/images/velkos.jpg'
    this.nikolako = '/assets/images/nikolako.png'

   }
  ngOnInit() {
  }

}

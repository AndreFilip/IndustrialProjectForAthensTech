import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-programs',
  templateUrl: './programs.component.html',
  styleUrls: ['./programs.component.css']
})
export class ProgramsComponent implements OnInit {
  java_seminar: string;
  react: string;

  
  constructor() {
    this.java_seminar = '/assets/images/java_seminar.png';
    this.react = '/assets/images/react.png'

   }
  ngOnInit() {
  }

}

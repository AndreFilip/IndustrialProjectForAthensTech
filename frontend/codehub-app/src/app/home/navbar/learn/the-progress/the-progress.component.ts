import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-the-progress',
  templateUrl: './the-progress.component.html',
  styleUrls: ['./the-progress.component.css']
})
export class TheProgressComponent implements OnInit {

  fullImagePath: string;
  fullImagePath3: string;


  constructor() {
    this.fullImagePath = '/assets/images/image_codelearn.jpg'
    this.fullImagePath3 = '/assets/images/program-structure.jpg'
   }

  ngOnInit() {
  }

}

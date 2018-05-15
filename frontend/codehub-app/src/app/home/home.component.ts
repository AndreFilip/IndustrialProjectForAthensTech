import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  fullImagePath: string;
  fullImagePath2: string;


  constructor() {

    this.fullImagePath = 'assets/images/image_codelearn.jpg'
    this.fullImagePath2 = 'assets/images/code-carreer.jpg'

   }

  ngOnInit() {
  }

}

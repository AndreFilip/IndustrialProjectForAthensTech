import { Component, OnInit } from '@angular/core';
import {JobpostsService} from '../../../../jobposts.service';


@Component({
  selector: 'app-programs',
  templateUrl: './programs.component.html',
  styleUrls: ['./programs.component.css']
})
export class ProgramsComponent implements OnInit {
  java_seminar: string;
  react: string;

  teckstacks: any [];

  constructor(private jobpostsService: JobpostsService) {
    this.java_seminar = '/assets/images/java_seminar.png';
    this.react = '/assets/images/react.png';
   }

  ngOnInit() {
    this.getAllStacks();
  }

  getAllStacks() {
    this.jobpostsService.getAllStacks().subscribe(
      response => { 
                  console.log(response);
                  // alert("Successfully fetched teckstacks.");              
                  this.teckstacks = response;
                  } ,
      err =>      {
                  console.log(err);
                  // alert("Unsuccessfully fetched teckstacks and hardcode-generated.");
                  this.teckstacks = [
                                     {stack:"randomStack"},
                                     {stack:"Error."},
                                     {stack:"Not fetching stacks"},
                                     {stack:"from server"}
                                    ];
              
                  }
    );
  }

}

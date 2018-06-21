import { Component, OnInit } from '@angular/core';
import {JobpostsService} from '../../../../jobposts.service';
import {ProgramService} from '../../../../programs.service';
import { Program } from '../../../../program.model';

@Component({
  selector: 'app-programs',
  templateUrl: './programs.component.html',
  styleUrls: ['./programs.component.css']
})
export class ProgramsComponent implements OnInit {
  java_seminar: string;
  react: string;

  teckstacks: any [];
  programs: Program [];

  notChooseProgram: boolean = true;
  theProgram: Program;  

  constructor(private jobpostsService: JobpostsService, private programService: ProgramService) {
    this.java_seminar = '/assets/images/java_seminar.png';
    this.react = '/assets/images/react.png';
   }

  ngOnInit() {
    this.getAllStacks();
    this.getPrograms();
  }

  onSelectProgram(program: Program): void {
    this.theProgram = program;
    this.notChooseProgram = false;
  }

  onProgramExit() {
    this.theProgram = null;
    this.notChooseProgram = true;
  }

  getAllStacks() {
    this.jobpostsService.getAllStacks().subscribe(
      response => { 
                  console.log(response);
                  this.teckstacks = response;
                  } ,
      err =>      {
                  console.log(err);
                  this.teckstacks = [
                                     {stack:"randomStack"},
                                     {stack:"Error."},
                                     {stack:"Not fetching stacks"},
                                     {stack:"from server"}
                                    ];
              
                  }
    );
  }
  
  getPrograms() {
    this.programService.getPrograms().subscribe(
      response => { 
                  console.log(response);
                  this.programs = response;
                  } ,
      err =>      {
                  console.log(err);
                  this.programs = [  { programTitle:"programTitle",
                                      price: "price",
                                      smallDescription: "smallDescription",
                                      mainDescription: "mainDescription",
                                      additionalInfo: "additionalInfo",
                                      category:"category",
                                      programLogo: "programLogo"
                                      },
                                      { programTitle:"programTitle2",
                                      price: "price2",
                                      smallDescription: "smallDescription2",
                                      mainDescription: "mainDescription2",
                                      additionalInfo: "additionalInfo2",
                                      category:"category2",
                                      programLogo: "programLogo2"
                                      }
                                     
                                     
                                    ];
              
                  }
    );
  }
}

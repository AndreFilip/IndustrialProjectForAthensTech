import { Component, OnInit } from '@angular/core';
import { Program } from '../../../program.model';
import { NgForm } from '@angular/forms';
import { ProgramService } from '../../../programs.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  program: Program;

  constructor(private programService: ProgramService) { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    const value = form.value;
    const addProgram = <Program> {
      programTitle: value.programTitle,
      price: value.price,
      smallDescription: value.smallDescription,
      mainDescription: value.mainDescription,
      additionalInfo: value.additionalInfo,
      category: value.category,
      programLogo: value.programLogo
    };
    this.programService.createProgram(addProgram);
    form.reset();
  }

}

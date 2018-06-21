import { Component, OnInit,Input, Output, EventEmitter } from '@angular/core';
import {Program} from '../../../../program.model';


@Component({
  selector: 'app-programsdetail',
  templateUrl: './programsdetail.component.html',
  styleUrls: ['./programsdetail.component.css']
})
export class ProgramsdetailComponent implements OnInit {
  @Input() selectedProgram: Program;
  @Output() programExit = new EventEmitter;  

  constructor() { }

  ngOnInit() {
  }

  onExit() {
    this.programExit.emit();
  }

}

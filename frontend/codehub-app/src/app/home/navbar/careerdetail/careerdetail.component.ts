import { Component, OnInit,Input, Output, EventEmitter } from '@angular/core';
import {Job} from '../../../job.model';
import {JobpostsService} from '../../../jobposts.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-careerdetail',
  templateUrl: './careerdetail.component.html',
  styleUrls: ['./careerdetail.component.css']
})

export class CareerdetailComponent implements OnInit {
  @Input() selectedJob: Job;
  @Output() jobExit = new EventEmitter;   

  userAndJobinfo = {};

  constructor( private route: ActivatedRoute, private jobpostsService: JobpostsService) { }

  ngOnInit() { }

  onExit() {
    this.jobExit.emit();
  }



}

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
  jobs: Job [];
  @Input() selectedJob: Job;
  @Output() jobExit = new EventEmitter;   

  userAndJobinfo = {};

  constructor( private route: ActivatedRoute, private jobpostsService: JobpostsService) { }

  ngOnInit() { }

  onExit() {
    this.jobExit.emit();
  }

  applyForJob(userAndJobinfo) {
    this.jobpostsService.applyForJob(userAndJobinfo).subscribe(
      response => { 
                  console.log(response);
                  alert("You applied successfully.");
                  this.jobExit.emit();
                  } ,
      err =>      {
                  console.log(err);
                  alert("Something went wrong. You did not apply successfully.");                  
                  }
    );

  }

  // getJobsByJobTitle(): void {
  //   const stringjobtitle = this.route.snapshot.paramMap.get('jobtitle');
  //   this.jobpostsService.getJobsByJobTitle(stringjobtitle)
  //     .subscribe(x => this.jobs = x);
  // }




}

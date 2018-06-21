import { Component, OnInit } from '@angular/core';
import { Job } from '../../../job.model';
import { JobpostsService } from '../../../jobposts.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-career',
  templateUrl: './career.component.html',
  styleUrls: ['./career.component.css']
})

export class CareerComponent implements OnInit {
  jobs: Job [];
  notChooseJob: boolean = true;
  theJob: Job;  
  jobtitleInput: string;
  locationInput: string;; 

  constructor(private jobpostsService: JobpostsService) { }

  ngOnInit() {
    this.getJobs();   
  }

  getJobs() {
    this.jobpostsService.getJobs().subscribe(x => this.jobs = x);
  }

  onSelectJob(job: Job): void {
    this.theJob = job;
    this.notChooseJob = false;
  }

  onJobExit() {
    this.theJob = null;
    this.notChooseJob = true;
  }

  clear() {
    this.jobtitleInput = "";
    this.locationInput = ""; 
    this.jobpostsService.getJobs().subscribe(x => this.jobs = x);
  }

  onSearch(form: NgForm){
    
    this.jobtitleInput = form.value.jobtitleInput;
    this.locationInput = form.value.locationInput; 
    console.log(this.jobtitleInput + "  " + this.locationInput);
    
    this.jobpostsService.getJobsByJobTitle(this.jobtitleInput).subscribe(
      response => { 
                  console.log(response);
                  this.jobs = [];
                  this.jobs = response;
                  } ,
      err =>      {
                  console.log(err);                  
                  this.jobs = [];                           
                  }
    );

    this.jobpostsService.getJobPostsByLocation(this.locationInput).subscribe(
      response => { 
                  console.log(response);
                  this.jobs = this.jobs.concat(response);
                  if (this.jobs.length == 0) {
                    alert("No jobs found with these search criteria");
                  }
                  } ,
      err =>      {
                  console.log(err);
                  this.jobs = this.jobs.concat([]);
                  if (this.jobs.length == 0) {
                    alert("Error. ");
                  }
                  }
    );

  } //end onSearch


  }

  
 
  




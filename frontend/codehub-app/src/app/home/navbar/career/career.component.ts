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
  stacks: any [];
  notChooseJob: boolean = true;

  theJob: Job;  
  jobtitleInput;
  locationInput;
  jobs2: any [];
  

  constructor(private jobpostsService: JobpostsService) { }

  ngOnInit() {
    this.getJobs();
    // this.getAllStacks();

    // this.jobs2 = [ {
    //   jobTitle: "jobTitle",
    //   location: "location1", 
    //   description: "description" ,
    //   companyTitle: "companyTitle" , 
    //   companyDescription: "companyDescription" ,
    //   qualifications: "qualifications" , 
    //   dateCreated: new Date(),
    //   companyLogo: "companyLogo"
    // },  
    // {
    //   jobTitle: "jobTitle2",
    //   location: "location2", 
    //   description: "description2" ,
    //   companyTitle: "companyTitle2" , 
    //   companyDescription: "companyDescription2" ,
    //   qualifications: "qualifications2" , 
    //   dateCreated: new Date(),
    //   companyLogo: "companyLogo2"
    // },
    // {
    //   jobTitle: "jobTitle3",
    //   location: "location3", 
    //   description: "description3" ,
    //   companyTitle: "companyTitle3" , 
    //   companyDescription: "companyDescription3" ,
    //   qualifications: "qualifications3" , 
    //   dateCreated: new Date(),
    //   companyLogo: "companyLogo3"
    // }  
    // ];  
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

  // getAllStacks() {
  //   this.jobpostsService.getAllStacks().subscribe(
  //     response => { 
  //                 console.log(response);
  //                 // alert("Successfully fetched teckstacks.");              
  //                 this.stacks = response;
  //                 } ,
  //     err =>      {
  //                 console.log(err);
  //                 // alert("Unsuccessfully fetched teckstacks and hardcode-generated.");
  //                 this.stacks =     [ {stack:"J2EE"},
  //                                     {stack:".NET"},
  //                                     {stack:"Angular5"},
  //                                     {stack:"randomStack"},
  //                                     {stack:"Also, error"},
  //                                     {stack:"fetching stacks"},
  //                                     {stack:"from server"}
  //                                   ];
              
  //                 }
  //   );
  // }

  onSearch(form: NgForm){
    
    this.jobtitleInput = form.value.jobtitleInput;
    this.locationInput = form.value.locationInput; 
    
    this.jobpostsService.getJobsByJobTitle(this.jobtitleInput).subscribe(
      response => { 
                  console.log(response);
                  this.jobs = [];
                  this.jobs = response;
                  } ,
      err =>      {
                  console.log(err);
                  alert("Unsuccessfully fetched by jobtitles.");
                  this.jobs = [];
                  this.jobs = [ {
                    jobTitle: "jobTitle..jobtitleInputttttt",
                    location: "location1", 
                    description: "description" ,
                    companyTitle: "companyTitle" , 
                    companyDescription: "companyDescription" ,
                    qualifications: "qualifications" , 
                    dateCreated: new Date(),
                    companyLogo: "companyLogo"
                  },  
                  {
                    jobTitle: "jobTitle2",
                    location: "location2", 
                    description: "description2" ,
                    companyTitle: "companyTitle2" , 
                    companyDescription: "companyDescription2" ,
                    qualifications: "qualifications2" , 
                    dateCreated: new Date(),
                    companyLogo: "companyLogo2"
                  },
                  {
                    jobTitle: "jobTitle3",
                    location: "location3", 
                    description: "description3" ,
                    companyTitle: "companyTitle3" , 
                    companyDescription: "companyDescription3" ,
                    qualifications: "qualifications3" , 
                    dateCreated: new Date(),
                    companyLogo: "companyLogo3"
                  }  
                  ];  
              
                  }
    );

    this.jobpostsService.getJobPostsByLocation(this.locationInput).subscribe(
      response => { 
                  console.log(response);
                  this.jobs = this.jobs.concat(response);
                  } ,
      err =>      {
                  console.log(err);
                  alert("Unsuccessfully fetched jobs by location.");
                  this.jobs = this.jobs.concat([ {
                    jobTitle: "jobTitlelocationsssssss",
                    location: "location1", 
                    description: "description" ,
                    companyTitle: "companyTitle" , 
                    companyDescription: "companyDescription" ,
                    qualifications: "qualifications" , 
                    dateCreated: new Date(),
                    companyLogo: "companyLogo"
                  },  
                  {
                    jobTitle: "jobTitle2",
                    location: "location2", 
                    description: "description2" ,
                    companyTitle: "companyTitle2" , 
                    companyDescription: "companyDescription2" ,
                    qualifications: "qualifications2" , 
                    dateCreated: new Date(),
                    companyLogo: "companyLogo2"
                  },
                  {
                    jobTitle: "jobTitle3",
                    location: "location3", 
                    description: "description3" ,
                    companyTitle: "companyTitle3" , 
                    companyDescription: "companyDescription3" ,
                    qualifications: "qualifications3" , 
                    dateCreated: new Date(),
                    companyLogo: "companyLogo3"
                  }  
                  ]);
              
                  }
    );


  } //end onSearch


  }

  
 
  




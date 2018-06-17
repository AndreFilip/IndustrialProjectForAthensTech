import { Component, OnInit } from '@angular/core';
import {Job} from '../../../job.model';
import {JobpostsService} from '../../../jobposts.service';

@Component({
  selector: 'app-career',
  templateUrl: './career.component.html',
  styleUrls: ['./career.component.css']
})
export class CareerComponent implements OnInit {
  jobs: Job [];

  // jobs2 = [ {
  //   jobTitle: "jobTitle",
  //   location: "location", 
  //   description: "description" ,
  //   companyTitle: "companyTitle" , 
  //   companyDescription: "companyDescription" ,
  //   qualifications: "qualifications" , 
  //   companyLogo: "companyLogo"
  // },  
  // {
  //   jobTitle: "jobTitle2",
  //   location: "location2", 
  //   description: "description2" ,
  //   companyTitle: "companyTitle2" , 
  //   companyDescription: "companyDescription2" ,
  //   qualifications: "qualifications2" , 
  //   companyLogo: "companyLogo2"
  // },
  // {
  //   jobTitle: "jobTitle3",
  //   location: "location3", 
  //   description: "description3" ,
  //   companyTitle: "companyTitle3" , 
  //   companyDescription: "companyDescription3" ,
  //   qualifications: "qualifications3" , 
  //   companyLogo: "companyLogo3"
  // }  
  // ];  

  constructor(private jobpostsService: JobpostsService) { }

  ngOnInit() {
    this.getJobs();
  }

  getJobs(): void {
    this.jobpostsService.getJobs().subscribe(x => this.jobs = x);
  }

}


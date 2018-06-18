import { Component, OnInit,Input } from '@angular/core';
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

  // jobs = [ {
  //   jobTitle: "jobTitle",
  //   location: "location", 
  //   description: "description" ,
  //   companyTitle: "companyTitle" , 
  //   companyDescription: "companyDescription" ,
  //   qualifications: "qualifications" , 
  //   companyLogo: "companyLogo"
  // }
  // ];  

  constructor(
    private route: ActivatedRoute,
    private jobpostsService: JobpostsService) { }

  ngOnInit() {
    this.getJobsByJobTitle();
  }

  getJobsByJobTitle(): void {
    const stringjobtitle = this.route.snapshot.paramMap.get('jobtitle');
    this.jobpostsService.getJobsByJobTitle(stringjobtitle)
      .subscribe(x => this.jobs = x);
  }


}

import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Job } from '../../../job.model';
import { JobpostsService } from '../../../jobposts.service';

@Component({
  selector: 'app-job-posts',
  templateUrl: './job-posts.component.html',
  styleUrls: ['./job-posts.component.css']
})
export class JobPostsComponent implements OnInit {

  job: Job;
  constructor(private jobService: JobpostsService) { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    const value = form.value;
    const addJob = <Job> {
      jobTitle: value.jobTitle,
      location: value.location,
      description: value.jobDescription,
      companyTitle: value.companyTitle,
      companyDescription: value.companyDescription,
      qualifications: value.qualifications,
      companyLogo: value.companyDescription
    };
    this.jobService.applyForJob(addJob);
    form.reset();
  }


}

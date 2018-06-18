import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import {Job} from './job.model';


@Injectable()
export class JobpostsService {
  private getJobsURL = 'http://localhost:8088/api/jobPosts/getAll';  
  private getJobsByJobTitleURL = 'http://localhost:8088/api/jobPosts/getJobPostsByJobTitle';

  constructor(private http: HttpClient) { }

  getJobs(): Observable<Job[]> {    
    return this.http.get<Job[]>(this.getJobsURL);
  }

  getJobsByJobTitle(jobtitle: string): Observable<Job[]> {    
    return this.http.get<Job[]>(this.getJobsByJobTitleURL + "/" + jobtitle);
  }

}

//JAVA BACKEND endpoints:  
// basic: http://localhost:8088/api/jobPosts
// 
//  /getAll
//  /getJobPostsByJobTitle/{jobTitle}"


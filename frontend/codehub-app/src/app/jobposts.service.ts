import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from "rxjs/observable/of";
import {Job} from './job.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class JobpostsService {
  private getJobsURL = 'http://localhost:8088/api/jobPosts/getAll';  
  private getJobsByJobTitleURL = 'http://localhost:8088/api/jobPosts/getJobPostsByJobTitle';
  private getJobPostsByLocationURL = 'http://localhost:8088/api/jobPosts/getJobPostsByLocation';

  

  constructor(private http: HttpClient) { }

  getJobs(): Observable<Job[]> {    
    return this.http.get<Job[]>(this.getJobsURL);
  }

  //todo change endpoint
  private applyForJobURL = 'http://localhost:8088/api/jobPosts/??';  
  applyForJob(userAndJobinfo): Observable<any> {    
    return this.http.post<any>(this.applyForJobURL, JSON.stringify(userAndJobinfo), httpOptions);
  }

  private getAllStacksURL = 'http://localhost:8088/api/techstack/getAll';  
  getAllStacks(): Observable<any[]> {    
    return this.http.get<any[]>(this.getAllStacksURL);
  }

  getJobsByJobTitle(jobtitle: string): Observable<Job[]> {
    if (!jobtitle.trim()) {
      return of([])
    };
     
    return this.http.get<Job[]>(this.getJobsByJobTitleURL + "/" + jobtitle);
  }

  getJobPostsByLocation(location: string): Observable<Job[]> {
    if (!location.trim()) {
      return of([])
    };     
    return this.http.get<Job[]>(this.getJobsByJobTitleURL + "/" + location);
  }
}


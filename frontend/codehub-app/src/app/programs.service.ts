import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router} from '@angular/router';
import { Program } from './program.model';
import { Observable } from 'rxjs/Observable';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class ProgramService {

  constructor(private http: HttpClient, private router: Router) {}


  private createProgramURL = 'http://localhost:8088/api/programs/createProgram';
  createProgram(program: Program): any {
    return this.http.post<any>(this.createProgramURL, JSON.stringify(program), httpOptions);
  }

  private getProgramsURL = 'http://localhost:8088/api/programs/getAll';
  getPrograms(): Observable<Program[]> {
    return this.http.get<Program[]>(this.getProgramsURL);
  }

  
}

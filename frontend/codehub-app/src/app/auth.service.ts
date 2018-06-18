import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AuthService {

  baseUrl: 'http://localhost:8088/api/';

  constructor(private http: HttpClient) {
  }

  attemptAuth(email: string, password: string): Observable<any> {
    const credentials = {email: email, password: password};
    console.log('attempAuth ::');
    console.log('CRED: ', credentials);
    return this.http.post('http://localhost:8088/api/token/generate-token', credentials);
  }

}

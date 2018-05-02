import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './user.model';
import { Observable } from 'rxjs/Observable';
import {tap} from "rxjs/operators";

@Injectable()
export class UserService {

  private Url = 'http://localhost:8088/api/userService/register';

  constructor(private http: HttpClient) {}

  // addUser (user: User): Observable<User> {
  //   return this.http.post<User>(this.Url, user, httpOptions).pipe(
  //     tap((user: User) => this.log(`added user w/ id=${user.name}`)),
  //     catchError(this.handleError<User>('addHero'))
  //   );
  // }

}

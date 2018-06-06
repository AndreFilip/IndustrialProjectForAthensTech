import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './user.model';
import { Observable } from 'rxjs/Observable';
import {tap} from "rxjs/operators";

// const httpOptions = {
//   headers: new HttpHeaders({ 'Content-Type': 'application/json' })
// };

@Injectable()
export class UserService {
  // UserService should know logged in user?
  user: User ;

  private basicUrl = 'http://localhost:8088/api/userService/';  

  constructor(private http: HttpClient) {}


  // getUser(email: string): Observable<User> {
  //   const url = `${this.basicUrl}/getUserByEmai/${email}`;
  //   return this.http.get<User>(url);
  // }

  // addUser (user: User): Observable<User> {
  //   return this.http.post<User>(this.basicUrl, user, httpOptions).pipe(
  //     tap((user: User) => this.log(`added user w/ id=${user.name}`)),
  //     catchError(this.handleError<User>('addHero'))
  //   );
  // }

}

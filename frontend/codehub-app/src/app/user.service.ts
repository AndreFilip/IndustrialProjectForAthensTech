import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './user.model';
import { Observable } from 'rxjs/Observable';
import { Router} from '@angular/router';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class UserService {  

  private basicUrl = 'http://localhost:8088/api/userService';    

  constructor(private http: HttpClient, private router: Router) {}
  
  private registerURL = 'http://localhost:8088/api/userService/register';
  registerUser(user: User): any {
    return this.http.post<any>(this.registerURL, JSON.stringify(user), httpOptions);    
  }  

  //todo change endpoint
  // tslint:disable-next-line:member-ordering
  private loginURL = 'http://localhost:8088/api/userService/login';  
  loginUser(user): any {
    return this.http.post<any>(this.loginURL, JSON.stringify(user) , httpOptions);
  }

  //todo change endpoint
  // tslint:disable-next-line:member-ordering
  private editProfileURL = 'http://localhost:8088/api/userService/';
  editProfile(user: User): any {
    return this.http.put(this.editProfileURL,  JSON.stringify(user), httpOptions);
  }

  //todo change endpoint
  // tslint:disable-next-line:member-ordering
  private getUsersURL = 'http://localhost:8088/api/userService/';  
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.getUsersURL);
  }

  // tslint:disable-next-line:member-ordering
  private getUserURL = 'http://localhost:8088/api/userService/getUserByEmail';   
  getUser(email: string): Observable<User> {
    return this.http.get<User>(this.getUserURL + "/" + email);
  }

}

  // addUser (user: User): Observable<User> {
  //   return this.http.post<User>(this.basicUrl, user, httpOptions).pipe(
  //     tap((user: User) => this.log(`added user w/ id=${user.name}`)),
  //     catchError(this.handleError<User>('addHero'))
  //   );
  // }


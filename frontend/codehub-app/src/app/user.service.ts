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
  private loginURL = 'http://localhost:8088/api/userService/';  
  loginUser(user): any {
    return this.http.post<any>(this.loginURL, JSON.stringify(user) , httpOptions);
  }

  //todo change endpoint
  private editProfileURL = 'http://localhost:8088/api/userService/';
  editProfile(user: User): any {
    return this.http.put(this.editProfileURL,  JSON.stringify(user), httpOptions);
  }

  //todo change endpoint
  private getUsersURL = 'http://localhost:8088/api/userService/';  
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.getUsersURL);
  }

  private getUserURL = 'http://localhost:8088/api/userService/getUserByEmai';   
  getUser(email: string): Observable<User> {
    return this.http.get<User>(this.getUserURL + "/" + email);
  }

  loggedIn() {
    return !!localStorage.getItem("token");    
  }

  getToken() {
    return localStorage.getItem("token");    
  }

  logOut() {
    localStorage.removeItem("token");    
    alert('You successfully logged out.');
    this.router.navigate['/'];
  } 

}

  // addUser (user: User): Observable<User> {
  //   return this.http.post<User>(this.basicUrl, user, httpOptions).pipe(
  //     tap((user: User) => this.log(`added user w/ id=${user.name}`)),
  //     catchError(this.handleError<User>('addHero'))
  //   );
  // }


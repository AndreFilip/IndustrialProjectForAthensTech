import { Injectable, Injector } from '@angular/core';
import {HttpInterceptor, HttpEvent, HttpErrorResponse} from '@angular/common/http';
import {UserService} from './user.service';
import { Router} from '@angular/router';
import 'rxjs/add/operator/do';

@Injectable()
export class TokenInterceptorService implements HttpInterceptor {

  constructor(private injector: Injector, private router: Router) { }

  intercept(req, next) {
    let userService = this.injector.get(UserService)
    let tokenizedReq = req.clone({
      setHeaders: { 
        Authorization: `Bearer ${userService.getToken()}`
      }
    })
    return next.handle(tokenizedReq).do((event: HttpEvent<any>) => {}, 
    (error: any) => {
                      if (error instanceof HttpErrorResponse) {
                        /*error.status === 401 || error.status === 403*/ 
                        if (error.status >= 400 && error.status <= 499)   {
                          alert('You are not authorized. Log in/Sign up in order to see this page.');
                          this.router.navigate(['/login']);
                        }
                      }   

                    }
    );
  }

}

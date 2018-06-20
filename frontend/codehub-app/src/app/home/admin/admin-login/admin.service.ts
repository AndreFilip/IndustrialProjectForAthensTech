import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';


@Injectable()
export class AdminService {

  logedInAdmin = new BehaviorSubject(false);

}

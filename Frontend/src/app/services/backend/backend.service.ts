import { Injectable } from '@angular/core';
import { Car } from '../../types/car.type';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

import { HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/types/user.type';
import { Repair } from 'src/app/types/repair.type';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  header = new HttpHeaders();
  url = 'http://192.168.0.222:8085';
  

  constructor(private http: HttpClient) {
    this.header.set('Access-Control-Allow-Origin', '*');
    this.header.set('Access-Control-Allow-Headers', 'Content-Type');
    this.header.set('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
   }

  login(username: String, password: String){
    let user = new User(username, password);
    return this.http.post<User>(this.url.concat('/user/login'), user, {headers: this.header});
  }

  loadCars(userId: Number){
      // let c: Car[];
      // c = [...[new Car("44847", "1-03-2020", "BT66789", "Ferrari")]];
      // c.push(...[new Car("44848", "1-03-2020", "BT66789", "Alpine")]);
      // c.push(...[new Car("44849", "1-03-2020", "BT66789", "RedBull")]);
      // c.push(...[new Car("44850", "1-03-2020", "BT66789", "Toyota")]);
      // c.push(...[new Car("44851", "1-03-2020", "BT66789", "To")]);
      return this.http.get<Car[]>(this.url.concat(`/cars/${userId}`), {headers: this.header});
  }

  loadRepairs(carId: String): Repair[]{
      return [{} as Repair, {} as Repair ];
  }
}

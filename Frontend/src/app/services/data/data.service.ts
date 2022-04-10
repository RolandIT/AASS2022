import { Injectable } from '@angular/core';
import { Car } from 'src/app/types/car.type';
import { User } from 'src/app/types/user.type';
import { BackendService } from '../backend/backend.service';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  currentUser!: User;
  carsList!: Car[];
  selectedCar!: Car;

  constructor(private backendService: BackendService) { }

  public getUserName(){
    return this.currentUser.username;
  }

  public getUserType(){
    return this.currentUser.type;
  }

  public loadRepairs(){
    this.selectedCar.repairs = this.backendService.loadRepairs(this.selectedCar.id);
  }
}

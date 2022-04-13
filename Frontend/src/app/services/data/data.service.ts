import { Injectable } from '@angular/core';
import { Car } from 'src/app/types/car.type';
import { loggedUser } from 'src/app/types/loggedUser.type';
import { RegisterCustomer } from 'src/app/types/registerCustomer.type';
import { Repair } from 'src/app/types/repair.type';
import { User } from 'src/app/types/user.type';
import { BackendService } from '../backend/backend.service';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  currentUser!: loggedUser;
  carsList!: Car[];
  selectedCar!: Car;
  selectedRepair!: Repair;

  constructor(private backendService: BackendService) { }

  public getUserName(){
    return this.currentUser.user.username;
  }

  public getUserType(){
    return this.currentUser.user.type;
  }

  public loadRepairs(){
    this.backendService.loadRepairs(this.selectedCar.id).subscribe({
      next: data => {
        this.selectedCar.repairs = data;
    },
      error: error => {
      console.error('There was an error!', error);
    }});
  }

  public addNewRepair(repair: Repair){
    console.log(repair);
    this.backendService.addNewRepair(repair).subscribe({
      next: data => {
          this.selectedCar.repairs?.push(...[repair]);
      },
      error: error => {
          console.error("Problem inserting to the DB", error)
      }
    });
  }

  public addNewCar(car: Car){
    this.backendService.addNewCar(car).subscribe({
      next: data => {
          car.id = data;
          this.carsList.push(...[car]);
      },
      error: error => {
          console.error("Problem inserting to the DB", error)
      }
    });
  }

  public addNewUser(user: RegisterCustomer){
    this.backendService.addNewUser(user).subscribe({
      next: data => {
         
      },
      error: error => {
          console.error("Problem inserting to the DB", error)
      }
    });
  }
}

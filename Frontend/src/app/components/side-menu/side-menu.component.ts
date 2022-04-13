import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { DataService } from 'src/app/services/data/data.service';
import { Car } from 'src/app/types/car.type';
import { RegisterCustomer } from 'src/app/types/registerCustomer.type';
import { NewCarFormComponent } from '../new-car-form/new-car-form.component';
import { NewUserFormComponent } from '../new-user-form/new-user-form.component';

@Component({
  selector: 'app-side-menu',
  templateUrl: './side-menu.component.html',
  styleUrls: ['./side-menu.component.scss']
})
export class SideMenuComponent implements OnInit {

  constructor(public dialog: MatDialog,
              public dataService: DataService) { }

  ngOnInit(): void {
  }

  newCar(){
    let dialogRef = this.dialog.open(NewCarFormComponent, {
      height: '430px',
      width: '500px',
      panelClass: 'form-panel',
      data: {car: new Car(), state: false}
    });
    dialogRef.afterClosed().subscribe(result => {
      if(result != undefined && result.state){
        console.log(result.car);
        this.dataService.addNewCar(result.car);
      }
    });
  }

  newUser(){
    let dialogRef = this.dialog.open(NewUserFormComponent, {
      height: '430px',
      width: '500px',
      panelClass: 'form-panel',
      data: {user: new RegisterCustomer(), state: false}
    });
    dialogRef.afterClosed().subscribe(result => {
      if(result != undefined && result.state){
        this.dataService.addNewUser(result.user);
      }
    });
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BackendService } from 'src/app/services/backend/backend.service';
import { DataService } from 'src/app/services/data/data.service';
import { RenderService } from 'src/app/services/render/render.service';
import { Car } from 'src/app/types/car.type';
import { loggedUser } from 'src/app/types/loggedUser.type';
import { Repair } from 'src/app/types/repair.type';
import { User } from 'src/app/types/user.type';
import { CarsListComponent } from '../cars-list/cars-list.component';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  

  dataService: DataService;
  renderService: RenderService;
  constructor(private _router: Router,
              private backend: BackendService, 
              renderService: RenderService,
              dataService: DataService ) {
      this.dataService = dataService;
      this.renderService = renderService;
   }

  ngOnInit(): void {
    if(this.dataService.currentUser.user.type === 1){
      this.backend.loadCars(this.dataService.currentUser.customer.id).subscribe((data: Car[]) => {
        this.dataService.carsList = data;
      });
    }
    if(this.dataService.currentUser.user.type === 2 || this.dataService.currentUser.user.type){
      this.backend.loadAllCars().subscribe((data: Car[]) => {
        this.dataService.carsList = data;
      });
    }
  }

  logout(){
    this.renderService.actualContent = CarsListComponent;
    this.dataService.carsList = [];
    this.dataService.currentUser = new loggedUser();
    this.dataService.selectedCar = new Car();
    this.dataService.selectedRepair = new Repair();
    this._router.navigate(['login']);
  }

}

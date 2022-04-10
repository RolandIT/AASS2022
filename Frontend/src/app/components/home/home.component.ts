import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BackendService } from 'src/app/services/backend/backend.service';
import { DataService } from 'src/app/services/data/data.service';
import { RenderService } from 'src/app/services/render/render.service';
import { Car } from 'src/app/types/car.type';
import { User } from 'src/app/types/user.type';
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
      this.backend.loadCars(this.dataService.currentUser.id).subscribe((data: Car[]) => {
        console.log("cars loaded");
        this.dataService.carsList = data;
      });
  }

  logout(){
    this._router.navigate(['login']);
  }

}

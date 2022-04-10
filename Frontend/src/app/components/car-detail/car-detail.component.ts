import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data/data.service';
import { RenderService } from 'src/app/services/render/render.service';
import { CarCardComponent } from '../car-card/car-card.component';
import { CarsListComponent } from '../cars-list/cars-list.component';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.scss']
})
export class CarDetailComponent implements OnInit {

  dataService: DataService;
  constructor(private renderService: RenderService,
              dataService: DataService) { 
    this.renderService = renderService;
    this.dataService = dataService;
  }

  ngOnInit(): void {
  }

  back(): void{
    this.renderService.actualContent=CarsListComponent;
  }

}

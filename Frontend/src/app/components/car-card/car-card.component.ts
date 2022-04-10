import { Component, Input, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data/data.service';
import { RenderService } from 'src/app/services/render/render.service';
import { Car } from '../../types/car.type';
import { CarDetailComponent } from '../car-detail/car-detail.component';

@Component({
  selector: 'app-car-card',
  templateUrl: './car-card.component.html',
  styleUrls: ['./car-card.component.scss']
})
export class CarCardComponent implements OnInit {

  @Input() carModel!: Car;
  constructor(private renderService: RenderService,
              private dataService: DataService){
  }

  ngOnInit(): void {

  }

  carCardClick(){
    this.renderService.actualContent = CarDetailComponent;
    this.dataService.selectedCar = this.carModel;
    this.dataService.loadRepairs();
  }

}

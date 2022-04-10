import { Injectable } from '@angular/core';
import { CarsListComponent } from 'src/app/components/cars-list/cars-list.component';

@Injectable({
  providedIn: 'root'
})
export class RenderService {
  
  actualContent: any = CarsListComponent;
  constructor() { }
}

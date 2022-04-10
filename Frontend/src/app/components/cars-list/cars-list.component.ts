import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data/data.service';

@Component({
  selector: 'app-cars-list',
  templateUrl: './cars-list.component.html',
  styleUrls: ['./cars-list.component.scss']
})
export class CarsListComponent implements OnInit {

  dataService: DataService;
  
  constructor(dataService: DataService) { 
    this.dataService = dataService;
  }

  ngOnInit(): void {
  }

}

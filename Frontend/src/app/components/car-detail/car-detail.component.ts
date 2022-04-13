import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data/data.service';
import { RenderService } from 'src/app/services/render/render.service';
import { CarsListComponent } from '../cars-list/cars-list.component';
import {MatDialog} from '@angular/material/dialog';
import { NewRepairFormComponent } from '../new-repair-form/new-repair-form.component';
import { Repair } from 'src/app/types/repair.type';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.scss']
})
export class CarDetailComponent implements OnInit {

  newRepair!: Repair;
  constructor(public renderService: RenderService,
              public dataService: DataService,
              public dialog: MatDialog) { 
  }

  ngOnInit(): void {
    this.dataService.loadRepairs();
  }

  back(): void{
    this.renderService.actualContent=CarsListComponent;
  }

  edit(){
    this.newRepair = new Repair();
    this.newRepair.idCar = this.dataService.selectedCar.id;
    let dialogRef = this.dialog.open(NewRepairFormComponent, {
      height: '430px',
      width: '400px',
      panelClass: 'form-panel',
      data: {repair: this.newRepair, state: false}
    });
    dialogRef.afterClosed().subscribe(result => {
      if(result != undefined && result.state){
        result.repair.cost = +result.repair.cost;
        result.repair.state = +result.repair.state;
        this.dataService.addNewRepair(result.repair);
      }
    });
  }

}

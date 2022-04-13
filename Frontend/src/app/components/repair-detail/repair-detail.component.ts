import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data/data.service';
import { RenderService } from 'src/app/services/render/render.service';
import { RepairStateType } from 'src/app/types/repairStateType.type';
import { CarDetailComponent } from '../car-detail/car-detail.component';

@Component({
  selector: 'app-repair-detail',
  templateUrl: './repair-detail.component.html',
  styleUrls: ['./repair-detail.component.scss']
})
export class RepairDetailComponent implements OnInit {

  dataService: DataService;
  repairState!: String;
  constructor(private renderService: RenderService,
              dataService: DataService) {
                this.dataService = dataService;
                this.repairState = RepairStateType[this.dataService.selectedRepair.state-1];
               }

  ngOnInit(): void {
  }

  back(): void{
    this.renderService.actualContent = CarDetailComponent;
  }

}

import { Component, Input, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data/data.service';
import { RenderService } from 'src/app/services/render/render.service';
import { Repair } from 'src/app/types/repair.type';
import { RepairStateType } from 'src/app/types/repairStateType.type';
import { RepairDetailComponent } from '../repair-detail/repair-detail.component';

@Component({
  selector: 'app-repair-card',
  templateUrl: './repair-card.component.html',
  styleUrls: ['./repair-card.component.scss']
})
export class RepairCardComponent implements OnInit {


  @Input() repair!: Repair;
  repairState!: string;
  constructor(private renderService: RenderService,
              private dataService: DataService) {
               }
              
  ngOnInit(): void {
      this.repairState = RepairStateType[this.repair.state-1];
  }

  repairCardClick(){
    this.renderService.actualContent = RepairDetailComponent;
    console.log(this.repair);
    this.dataService.selectedRepair = this.repair;
  }
}

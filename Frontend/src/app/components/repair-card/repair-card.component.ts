import { Component, Input, OnInit } from '@angular/core';
import { Repair } from 'src/app/types/repair.type';

@Component({
  selector: 'app-repair-card',
  templateUrl: './repair-card.component.html',
  styleUrls: ['./repair-card.component.scss']
})
export class RepairCardComponent implements OnInit {

  @Input() repair!: Repair;
  constructor() { }

  ngOnInit(): void {
  }

}

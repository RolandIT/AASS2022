import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Repair } from 'src/app/types/repair.type';

@Component({
  selector: 'app-new-repair-form',
  templateUrl: './new-repair-form.component.html',
  styleUrls: ['./new-repair-form.component.scss']
})
export class NewRepairFormComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<NewRepairFormComponent>,
              @Inject(MAT_DIALOG_DATA) public data: {repair: Repair, state: boolean}) { }

  ngOnInit(): void {
  }

  onCloseDialog(){
    this.data.state = true;
    this.dialogRef.close(this.data);
  }
}

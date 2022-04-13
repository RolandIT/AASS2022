import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { RegisterCustomer } from 'src/app/types/registerCustomer.type';

@Component({
  selector: 'app-new-user-form',
  templateUrl: './new-user-form.component.html',
  styleUrls: ['./new-user-form.component.scss']
})
export class NewUserFormComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<NewUserFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: {user: RegisterCustomer, state: boolean}) { }

  ngOnInit(): void {
  }

  onCloseDialog(){
    console.log(this.data);
    this.data.state = true;
    this.dialogRef.close(this.data);
  }

}

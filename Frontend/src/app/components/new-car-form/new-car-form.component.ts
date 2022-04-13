import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatSelectModule} from '@angular/material/select';
import { Car } from 'src/app/types/car.type';
import { BackendService } from 'src/app/services/backend/backend.service';
import { Userfilter } from 'src/app/types/user-filter.type';
import { customer } from 'src/app/types/customer.type';
import { User } from 'src/app/types/user.type';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';

@Component({
  selector: 'app-new-car-form',
  templateUrl: './new-car-form.component.html',
  styleUrls: ['./new-car-form.component.scss']
})
export class NewCarFormComponent implements OnInit {

  myControl = new FormControl();
  owner: String = "";
  users!: customer[];
  filteredOptions!: Observable<customer[]>;
  ownerCustomer!: User;

  constructor(public dialogRef: MatDialogRef<NewCarFormComponent>,
    public backendService: BackendService,
    @Inject(MAT_DIALOG_DATA) public data: {car: Car, state: boolean}) { }

  ngOnInit(): void {
    let user = new Userfilter();
    user.surname = "";
    this.backendService.loadUsers(user).subscribe({
      next: data => {
         this.users = data;
      },
      error: error => {
          console.error("Problem retrieving users", error)
      }
    });

    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value)),
    );
  }

  private _filter(value: String): customer[] {
    const filterValue = value.toLowerCase();
    console.log(filterValue);
    return this.users.filter(user => user.surname.toLowerCase().includes(filterValue));
  }

  onCloseDialog(){
    this.data.state = true;
    this.data.car.idOwner = this.ownerCustomer.id;
    console.log(this.data);
    this.dialogRef.close(this.data);
  }

  displayFn(user: customer){
    return user.name + " " + user.surname;
  }

}

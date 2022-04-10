import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { DataService } from 'src/app/services/data/data.service';
import { UserType } from '../../types/userType.type';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  currentUser = this.dataService.getUserName();
  userType = UserType[this.dataService.getUserType() - 1];
  @Output() onLogout = new EventEmitter<void>();

  constructor(public dataService: DataService) { }



  ngOnInit(): void {
  }

  logout(){
    this.onLogout.emit();
  }

}

import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { BackendService } from 'src/app/services/backend/backend.service';
import { DataService } from 'src/app/services/data/data.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private _router: Router, 
              private backendService: BackendService, 
              private dataService: DataService) { }
  hide: Boolean = true;

  @Input() username!: String;

  @Input() password!: String;


  handleLogin(){
      console.log(this.username);
      this.backendService.login(this.username, this.password).subscribe({
        next: data => {
        this.dataService.currentUser = data;
        this._router.navigate(['home'])
      },
        error: error => {
        console.error('There was an error!', error);
      }});
      // this.dataService.currentUser = {username:"meno", type:1, id:5, password:""};
      // this._router.navigate(['home'])
  }

  ngOnInit(): void {
  }

}

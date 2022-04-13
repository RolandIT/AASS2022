import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { SideMenuComponent } from './components/side-menu/side-menu.component';
import { HttpClientModule } from '@angular/common/http';
import { CarCardComponent } from './components/car-card/car-card.component';
import { FormsModule } from '@angular/forms'
import {MatDialogModule} from '@angular/material/dialog';
import {MatSelectModule} from '@angular/material/select';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {ReactiveFormsModule} from '@angular/forms';

//services
import { CarDetailComponent } from './components/car-detail/car-detail.component';
import { CarsListComponent } from './components/cars-list/cars-list.component';
import { RepairCardComponent } from './components/repair-card/repair-card.component';
import { RepairDetailComponent } from './components/repair-detail/repair-detail.component';
import { NewCarFormComponent } from './components/new-car-form/new-car-form.component';
import { NewUserFormComponent } from './components/new-user-form/new-user-form.component';
import { NewRepairFormComponent } from './components/new-repair-form/new-repair-form.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    SideMenuComponent,
    CarCardComponent,
    CarDetailComponent,
    CarsListComponent,
    RepairCardComponent,
    RepairDetailComponent,
    NewCarFormComponent,
    NewUserFormComponent,
    NewRepairFormComponent,

  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    MatDialogModule,
    MatSelectModule,
    HttpClientModule,
    MatAutocompleteModule,
    FormsModule,
  ], 
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

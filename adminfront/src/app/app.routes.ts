import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListPropertiesComponent } from './list-properties/list-properties.component';
import { AddPropertyComponent } from './add-property/add-property.component';


export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'list', component: ListPropertiesComponent },
  { path: 'add', component: AddPropertyComponent }
];
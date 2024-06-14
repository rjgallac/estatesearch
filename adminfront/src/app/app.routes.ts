import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListPropertiesComponent } from './list-properties/list-properties.component';
import { AddPropertyComponent } from './add-property/add-property.component';
import { PropertyDetailComponent } from './property-detail/property-detail.component';
import { LoginComponent } from './login/login.component';


export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'list', component: ListPropertiesComponent },
  { path: 'add', component: AddPropertyComponent },
  { path: 'property-detail/:id', component: PropertyDetailComponent},
  { path: 'login', component: LoginComponent}
];
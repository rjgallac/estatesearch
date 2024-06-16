import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { DetailViewComponent } from './detail-view/detail-view.component';
import { LoginComponent } from './login/login.component';
import { SearchComponent } from './search/search.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'detail-view/:id', component: DetailViewComponent },
  { path: 'login', component: LoginComponent},
  { path: 'search', component: SearchComponent}
];

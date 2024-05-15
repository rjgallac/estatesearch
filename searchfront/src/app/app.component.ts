import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {SearchFormComponent} from './search-form/search-form.component'
import { PropertyService } from './property.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SearchFormComponent, HttpClientModule],
  providers: [PropertyService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'searchfront';
}

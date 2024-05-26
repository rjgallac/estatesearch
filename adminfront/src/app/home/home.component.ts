import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PropertyService } from '../property.service';
import {MatPaginatorModule} from '@angular/material/paginator';
import { PageEvent } from '@angular/material/paginator';
import { ListPropertiesComponent } from '../list-properties/list-properties.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, MatPaginatorModule, ListPropertiesComponent],
  templateUrl: './home.component.html',
  providers: [PropertyService],
  styleUrls: ['./home.component.css']
})
export class HomeComponent { 

  

  totalResults: number = 0;

  minPrice: number = 0;

  constructor(){}

}

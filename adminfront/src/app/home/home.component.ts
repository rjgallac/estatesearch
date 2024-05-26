import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PropertyService } from '../property.service';
import {MatPaginatorModule} from '@angular/material/paginator';
import { PageEvent } from '@angular/material/paginator';
import { ListPropertiesComponent } from '../list-properties/list-properties.component';
import { AddPropertyComponent } from '../add-property/add-property.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  providers: [],
  styleUrls: ['./home.component.css']
})
export class HomeComponent { 

  constructor(){}

}

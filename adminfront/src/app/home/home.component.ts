import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PropertyService } from '../property.service';
import {MatPaginatorModule} from '@angular/material/paginator';
import { PageEvent } from '@angular/material/paginator';
import { ListPropertiesComponent } from '../list-properties/list-properties.component';
import { AddPropertyComponent } from '../add-property/add-property.component';
import { Dashboard } from '../model/Dashboard';
import { Observable } from 'rxjs';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import { BarChartComponent } from '../bar-chart/bar-chart.component';
import { LineChartComponent } from '../line-chart/line-chart.component';
import { PieChartComponent } from '../pie-chart/pie-chart.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatCardModule, BarChartComponent, LineChartComponent, PieChartComponent],
  templateUrl: './home.component.html',
  providers: [PropertyService],
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{ 

  dashboard: Dashboard = new Dashboard();
  
  constructor(private propertyService: PropertyService){}
  
  
  ngOnInit() {
    this.propertyService.getDashboard().subscribe((dashboard: Dashboard) => {
      console.log("HERE")
      this.dashboard = dashboard;
    });
  }



}

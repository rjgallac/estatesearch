import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchFormComponent } from '../search-form/search-form.component'
import { SearchResultsComponent } from '../search-results/search-results.component'
import { PropertyService } from '../property.service';
import { PropertyResults } from '../model/PropertyResults';
import { MapComponent } from '../map/map.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, SearchFormComponent, SearchResultsComponent, MapComponent, MatPaginatorModule],
  templateUrl: './home.component.html',
  providers: [PropertyService],
  styleUrls: ['./home.component.css']
})
export class HomeComponent { 

  
  results: PropertyResults = new PropertyResults();

  searchString: string = "";

  totalResults: number = 0;

  constructor( private propertyService: PropertyService){}


  propertySearch(searchString: string, pageNo: number) {
    this.searchString = searchString;
    this.propertyService.getProperties(searchString, pageNo).subscribe( (propertyResults: PropertyResults) => {
      this.totalResults = propertyResults.totalResults;
      this.results = propertyResults;
    })
  }

  getServerData(event:PageEvent) {
    this.propertySearch(this.searchString, event?.pageIndex);
  }

}

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchFormComponent } from '../search-form/search-form.component'
import { SearchResultsComponent } from '../search-results/search-results.component'
import { PropertyService } from '../property.service';
import { PropertyResults } from '../model/PropertyResults';
import { MapComponent } from '../map/map.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import { PageEvent } from '@angular/material/paginator';
import { SearchForm } from '../model/SearchForm';

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

  searchForm: SearchForm = new SearchForm();

  totalResults: number = 0;

  minPrice: number = 0;

  constructor( private propertyService: PropertyService){}


  propertySearch(searchForm: SearchForm,  pageNo: number) {
    this.searchForm = searchForm;
    this.propertyService.getProperties(searchForm, pageNo).subscribe( (propertyResults: PropertyResults) => {
      this.totalResults = propertyResults.totalResults;
      this.results = propertyResults;
    })
  }

  getServerData(event:PageEvent) {
    this.propertySearch(this.searchForm, event?.pageIndex);
  }

}

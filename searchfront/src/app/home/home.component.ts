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

  constructor( private propertyService: PropertyService){}


  propertySearch(searchString: string, pageNo: number) {
    this.searchString = searchString;
    this.propertyService.getProperties(searchString, pageNo).subscribe( (propertyResults: PropertyResults) => {
      console.log("here" + this.searchString  )
      this.results = propertyResults;
    })
  }

  getServerData(event:PageEvent) {

    console.log(event?.pageIndex)
    // console.log(this.searchString)
    // this.propertySearch(this.searchString, event?.pageIndex);
  }

}

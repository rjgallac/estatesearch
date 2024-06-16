import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatPaginatorModule, PageEvent } from '@angular/material/paginator';
import { MapComponent } from '../map/map.component';
import { SearchFormComponent } from '../search-form/search-form.component';
import { SearchResultsComponent } from '../search-results/search-results.component';
import { SearchForm } from '../model/SearchForm';
import { ActivatedRoute, Router } from '@angular/router';
import { PropertyService } from '../property.service';
import { PropertyResults } from '../model/PropertyResults';

@Component({
  selector: 'app-search',
  standalone: true,
  imports: [CommonModule, SearchFormComponent, SearchResultsComponent, MapComponent, MatPaginatorModule],
  templateUrl: './search.component.html',
  providers: [PropertyService],
  styleUrl: './search.component.css'
})
export class SearchComponent {

  searchForm: SearchForm = new SearchForm();
  totalResults: number = 0;
  results: PropertyResults = new PropertyResults();


  constructor( private propertyService: PropertyService, private route: ActivatedRoute, private router: Router){}

  search(){
    this.propertyService.getProperties(this.searchForm, 0).subscribe( (propertyResults: PropertyResults) => {
      this.totalResults = propertyResults.totalResults;
      this.results = propertyResults;
    })
  }

  propertySearch(searchForm: SearchForm,  pageNo: number) {
    this.search();
  }

  getServerData(event:PageEvent) {
    this.propertySearch(this.searchForm, event?.pageIndex);
  }
}

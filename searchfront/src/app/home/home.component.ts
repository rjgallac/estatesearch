import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchFormComponent } from '../search-form/search-form.component'
import { SearchResultsComponent } from '../search-results/search-results.component'
import { PropertyService } from '../property.service';
import { PropertyResults } from '../model/PropertyResults';
import { MapComponent } from '../map/map.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import { PageEvent } from '@angular/material/paginator';
import { SearchForm } from '../model/SearchForm';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, SearchFormComponent, SearchResultsComponent, MapComponent, MatPaginatorModule],
  templateUrl: './home.component.html',
  providers: [PropertyService],
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{ 

  
  results: PropertyResults = new PropertyResults();

  searchForm: SearchForm = new SearchForm();

  totalResults: number = 0;

  minPrice: number = 0;


  constructor( private propertyService: PropertyService, private route: ActivatedRoute, private router: Router){}
  
  ngOnInit(): void {}

  propertySearch(searchForm: SearchForm,  pageNo: number) {
    this.router.navigate(["search"], {
      queryParams: {
        type: this.searchForm.type,
        houseType: this.searchForm.houseType,
        minPrice: this.searchForm.minPrice,
        maxPrice: this.searchForm.maxPrice,
        bedrooms: this.searchForm.bedrooms,
        terms: this.searchForm.terms
      },
      skipLocationChange: false
    })
    this.searchForm = searchForm;
    
  }
}

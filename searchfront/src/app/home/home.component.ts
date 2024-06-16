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
import { ActivatedRoute } from '@angular/router';

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


  constructor( private propertyService: PropertyService, private route: ActivatedRoute){}
  
  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.searchForm.type = params.get('type')!;
      this.searchForm.minPrice = params.get('minPrice')!;
      this.searchForm.bedrooms = params.get('bedrooms')!;
      console.log("init")
      // console.log(this.propertyId);
      // this.propertyDetailService.getDetail(this.propertyId).subscribe((property: Property) =>{
      //   this.property = property;
      // });
      // let view: View = new View();
      // this.analyticsService.view(view).subscribe();
      this.search();
    });
    
  }

  search(){
    this.propertyService.getProperties(this.searchForm, 0).subscribe( (propertyResults: PropertyResults) => {
      console.log("---" )

      this.totalResults = propertyResults.totalResults;
      this.results = propertyResults;
    })
  }


  propertySearch(searchForm: SearchForm,  pageNo: number) {
    this.search();
    this.searchForm = searchForm;
    
  }

  getServerData(event:PageEvent) {
    this.propertySearch(this.searchForm, event?.pageIndex);
  }

}

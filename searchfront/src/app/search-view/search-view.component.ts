import { Component, Injectable } from '@angular/core';
import { SearchFormComponent } from '../search-form/search-form.component'
import { SearchResultsComponent } from '../search-results/search-results.component'
import { PropertyService } from '../property.service';
import { Property } from '../model/Property'


@Component({
  selector: 'app-search-view',
  standalone: true,
  imports: [SearchFormComponent, SearchResultsComponent],
  providers: [PropertyService],
  templateUrl: './search-view.component.html',
  styleUrl: './search-view.component.css'
})
export class SearchViewComponent {

  results: Property[] = new Array();

  constructor( private propertyService: PropertyService){}


  propertySearch(name: string) {
    console.log("hi" + name)
    this.propertyService.getProperties(name).subscribe( (properties: Property[]) => {
      console.log(properties)
      this.results = properties
    })
    console.log(this.results)
  }
}

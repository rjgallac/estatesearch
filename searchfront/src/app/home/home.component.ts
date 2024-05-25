import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchFormComponent } from '../search-form/search-form.component'
import { SearchResultsComponent } from '../search-results/search-results.component'
import { PropertyService } from '../property.service';
import { Property } from '../model/Property'
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, SearchFormComponent, SearchResultsComponent],
  templateUrl: './home.component.html',
  providers: [PropertyService],
  styleUrls: ['./home.component.css']
})
export class HomeComponent { 

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

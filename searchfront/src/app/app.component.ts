import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SearchFormComponent } from './search-form/search-form.component'
import { SearchResultsComponent } from './search-results/search-results.component'
import { PropertyService } from './property.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Property } from './model/Property'

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SearchFormComponent, HttpClientModule, SearchResultsComponent, CommonModule],
  providers: [PropertyService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  title = 'searchfront';
  search = {
    "name": "beach"
  }
  results: Property[] = new Array();

  name = "";

  constructor(
    private propertyService: PropertyService){

    }

  propertySearch(name: string) {
    console.log("hi" + name)
    this.propertyService.getProperties(name).subscribe( (properties: Property[]) => {
      console.log(properties)
      this.results = properties
  })
    console.log(this.results)
  }
}

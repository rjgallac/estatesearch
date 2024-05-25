import { Component, Input } from '@angular/core';
import { PropertyService } from '../property.service';
import { Property } from '../model/Property'
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { PropertyResultComponent } from '../property-result/property-result.component'

@Component({
  selector: 'app-search-results',
  standalone: true,
  imports: [CommonModule, PropertyResultComponent],
  providers: [PropertyService],
  templateUrl: './search-results.component.html',
  styleUrl: './search-results.component.css'
})
export class SearchResultsComponent {


  @Input() results: Property[] = new Array();




  constructor(
    private propertyService: PropertyService){

    }
}

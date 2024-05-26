import { Component, OnInit } from '@angular/core';
import { PropertyResults } from '../model/PropertyResults';
import { PropertyService } from '../property.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-list-properties',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list-properties.component.html',
  styleUrl: './list-properties.component.css'
})
export class ListPropertiesComponent implements OnInit{

  results: PropertyResults = new PropertyResults();

  constructor(private propertyService: PropertyService){}
  ngOnInit(): void {
    this.propertyService.getProperties(0).subscribe((propertyResults: PropertyResults) => {
      this.results = propertyResults;
    })  }


}

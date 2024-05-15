import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-search-form',
  standalone: true,
  imports: [FormsModule],
  providers: [PropertyService],
  templateUrl: './search-form.component.html',
  styleUrl: './search-form.component.css'
})
export class SearchFormComponent {

  constructor(
    private propertyService: PropertyService){}

  search = {
    "name" : ""
  }

  onSubmit() { 
    console.log("HERE"); 
    this.propertyService.getProperties(this.search.name)
    
  }

}

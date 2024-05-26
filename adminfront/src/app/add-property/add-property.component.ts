import { Component } from '@angular/core';
import { Property } from '../model/Property';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { MatButton} from '@angular/material/button'
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatCardModule} from '@angular/material/card'
import { PropertyService } from '../property.service';
@Component({
  selector: 'app-add-property',
  standalone: true,
  imports: [FormsModule, MatButton, MatFormFieldModule, MatInputModule, MatSelectModule, MatCardModule],
  templateUrl: './add-property.component.html',
  styleUrl: './add-property.component.css',
  providers: [PropertyService]
})
export class AddPropertyComponent {

  property: Property = new Property();

  constructor(private propertyService: PropertyService){}

  onSubmit() { 
    this.propertyService.addProperty(this.property);
  }

}

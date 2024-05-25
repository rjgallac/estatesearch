import { Component, Input } from '@angular/core';
import { Property } from '../model/Property';
import { RouterLink } from '@angular/router';
import {MatCardModule} from '@angular/material/card'
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-property-result',
  standalone: true,
  imports: [RouterLink, MatCardModule, MatButtonModule],
  templateUrl: './property-result.component.html',
  styleUrl: './property-result.component.css'
})
export class PropertyResultComponent {
  @Input() property: Property = new Property();

}

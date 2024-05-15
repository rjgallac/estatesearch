import { Component, Input } from '@angular/core';
import { Property } from '../model/Property';

@Component({
  selector: 'app-property-result',
  standalone: true,
  imports: [],
  templateUrl: './property-result.component.html',
  styleUrl: './property-result.component.css'
})
export class PropertyResultComponent {
  @Input() property: Property = new Property();
}

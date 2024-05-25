import { Component, Input } from '@angular/core';
import { Property } from '../model/Property';
import { RouterLink } from '@angular/router';
import {MatCardModule} from '@angular/material/card'

@Component({
  selector: 'app-property-result',
  standalone: true,
  imports: [RouterLink, MatCardModule],
  templateUrl: './property-result.component.html',
  styleUrl: './property-result.component.css'
})
export class PropertyResultComponent {
  @Input() property: Property = new Property();

  randomIntFromInterval(min: number, max: number) { // min and max included 
    return Math.floor(Math.random() * (max - min + 1) + min);
  }

  randomimg() {
    return "http://localhost:81/home" + this.randomIntFromInterval(1,6) +".jpg";
  }

}

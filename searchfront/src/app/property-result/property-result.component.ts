import { Component, Input } from '@angular/core';
import { Property } from '../model/Property';
import { RouterLink } from '@angular/router';
import {MatCardModule} from '@angular/material/card'
import {MatButtonModule} from '@angular/material/button';
import { UserdataService } from '../userdata.service';
import { Like } from '../model/Like';

@Component({
  selector: 'app-property-result',
  standalone: true,
  imports: [RouterLink, MatCardModule, MatButtonModule],
  templateUrl: './property-result.component.html',
  styleUrl: './property-result.component.css',
  providers: [UserdataService]
})
export class PropertyResultComponent {

  constructor(private userDataService: UserdataService) {}

  @Input() property: Property = new Property();

  like(propertyId: number){
    let like: Like = new Like();
    like.propertyId = propertyId;

    like.userId = localStorage.getItem("sub")!;
    this.userDataService.like(like).subscribe(data => {});

  }

}

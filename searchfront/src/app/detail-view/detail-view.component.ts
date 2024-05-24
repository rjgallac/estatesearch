import { Component } from '@angular/core';
import { PropertyDetailService } from '../property-detail.service';

@Component({
  selector: 'app-detail-view',
  standalone: true,
  imports: [],
  providers: [PropertyDetailService],
  templateUrl: './detail-view.component.html',
  styleUrl: './detail-view.component.css'
})
export class DetailViewComponent {
  constructor(propertyDetailService: PropertyDetailService){
    propertyDetailService.getDetail().subscribe();
  }

}

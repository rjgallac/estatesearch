import { Component, OnInit } from '@angular/core';
import { PropertyDetailService } from '../property-detail.service';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { Property } from '../model/Property';
import { AnalyticsService } from '../analytics.service';
import { View } from '../model/View';

@Component({
  selector: 'app-detail-view',
  standalone: true,
  imports: [RouterLink, MatButtonModule],
  providers: [PropertyDetailService, AnalyticsService],
  templateUrl: './detail-view.component.html',
  styleUrl: './detail-view.component.css'
})
export class DetailViewComponent implements OnInit{

  propertyId: number = 0;

  property: Property = new Property();

  constructor(private propertyDetailService: PropertyDetailService,  private route: ActivatedRoute, private analyticsService: AnalyticsService){
    
  }
  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.propertyId = Number(params.get('id'));
      console.log(this.propertyId);
      this.propertyDetailService.getDetail(this.propertyId).subscribe((property: Property) =>{
        this.property = property;
      });
      let view: View = new View();
      view.propertyId = this.propertyId;
      this.analyticsService.view(view).subscribe();
    });

  }

}

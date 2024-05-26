import { Component, OnInit } from '@angular/core';
import { PropertyDetailService } from '../property-detail.service';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { Property } from '../model/Property';

@Component({
  selector: 'app-detail-view',
  standalone: true,
  imports: [RouterLink, MatButtonModule],
  providers: [PropertyDetailService],
  templateUrl: './detail-view.component.html',
  styleUrl: './detail-view.component.css'
})
export class DetailViewComponent implements OnInit{

  propertyId: number = 0;

  property: Property = new Property();

  constructor(private propertyDetailService: PropertyDetailService,  private route: ActivatedRoute){
    
  }
  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.propertyId = Number(params.get('id'));
      console.log(this.propertyId);
      this.propertyDetailService.getDetail(this.propertyId).subscribe((property: Property) =>{
        this.property = property;
      });
    });
  }

}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Property } from '../model/Property';
import { PropertyService } from '../property.service';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-property-detail',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './property-detail.component.html',
  providers: [PropertyService],
  styleUrl: './property-detail.component.css'
})
export class PropertyDetailComponent implements OnInit{

  fileName = '';
  
  property: Property = new Property();


  constructor(private http: HttpClient, private propertyService: PropertyService, private route: ActivatedRoute) {}

  ngOnInit(): void {

    this.route.paramMap.subscribe(params => {
      var id = Number(params.get('id'));
      console.log(id);
      this.propertyService.getProperty(id).subscribe((property: Property) =>{
        this.property = property;
      })
    });

   
  }


  onFileSelected(event: any) {
    const file:File = event.target.files[0];
    if (file) {
        this.fileName = file.name;
        const formData = new FormData();
        formData.append("file", file);
        const upload$ = this.http.post("http://127.0.0.1:8084/imageupload/" + this.property.id, formData);
        upload$.subscribe();
    }
}

}

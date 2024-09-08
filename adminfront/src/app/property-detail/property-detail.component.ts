import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Property } from '../model/Property';
import { PropertyService } from '../property.service';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { PropertyDto } from '../model/PropertyDto';

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

  propertyId: number = 0;


  constructor(private http: HttpClient, private propertyService: PropertyService, private route: ActivatedRoute) {}

  ngOnInit(): void {

    this.route.paramMap.subscribe(params => {
      this.propertyId = Number(params.get('id'));
      console.log(this.propertyId);
      this.getProperty(this.propertyId);
    });


  }


  onFileSelected(event: any) {
    const file:File = event.target.files[0];
    if (file) {
        this.fileName = file.name;
        const formData = new FormData();
        formData.append("file", file);
        const upload$ = this.http.post("http://127.0.0.1:8084/imageupload/" + this.property.id, formData);
        upload$.subscribe(() =>{
          this.getProperty(this.propertyId)
        });
    }
  }

  sendToSearch(property: Property) {
    let propertyDto: PropertyDto = new PropertyDto();
    propertyDto.description = property.description;
    propertyDto.bathrooms = property.bathrooms;
    propertyDto.bedrooms = property.bathrooms;
    propertyDto.price = property.price;
    propertyDto.address = property.address;
    propertyDto.propertyType = property.propertyType;
    propertyDto.type = property.type;
    propertyDto.propertyId = property.id;
    // need to compose dto here and send direct to search
     let options = {
              headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('token'))
              ,withCredentials: true
            };
    this.http.post('http://localhost:8080/search/property/post', property, options ).subscribe();
  }

  deleteFromSearch() {
    this.http.delete('http://localhost:8080/propertyinfo/propertyinfo/delete-from-search/'+ this.property.id).subscribe();

  }

  delete() {
    this.http.delete('http://localhost:8080/propertyinfo/propertyinfo/'+ this.property.id).subscribe();

  }

  deleteImage(id: number) {
    this.http.delete('http://localhost:8084/imageupload/'+ id).subscribe(() =>{
      this.getProperty(this.propertyId);
    });

  }

  getProperty(id: number){
    this.propertyService.getProperty(id).subscribe((property: Property) =>{
      this.property = property;
    })
  }
}

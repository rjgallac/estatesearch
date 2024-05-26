import { Injectable } from '@angular/core';
import { PropertyResults } from './model/PropertyResults';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Property } from './model/Property';

@Injectable({
  providedIn: 'root'
})
export class PropertyService {

  constructor(private http: HttpClient) { }

  getProperties(pageNo: number): Observable<PropertyResults> {
    return this.http.get<PropertyResults>('http://localhost:8082/propertyinfo?pageNo=' + pageNo );  
  }

  addProperty(property: Property) {
    this.http.post('http://localhost:8082/propertyinfo', property).subscribe();
  }
}

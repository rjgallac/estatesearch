import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Property } from './model/Property'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'

})
export class PropertyService {


  constructor(private http: HttpClient) { }

  getProperties(name: String): Observable<Property[]> {
    return this.http.get<Property[]>('http://localhost:8080/property/searchquery?query=' + name);  
  }
}

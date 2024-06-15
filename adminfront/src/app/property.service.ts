import { Injectable } from '@angular/core';
import { PropertyResults } from './model/PropertyResults';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Property } from './model/Property';
import { Dashboard } from './model/Dashboard';

@Injectable({
  providedIn: 'root'
})
export class PropertyService {

  constructor(private http: HttpClient) { }

  getProperties(pageNo: number): Observable<PropertyResults> {
    return this.http.get<PropertyResults>('http://localhost:8080/propertyinfo?pageNo=' + pageNo );  
  }

  addProperty(property: Property): Observable<Property> {
    return this.http.post<Property>('http://localhost:8080/propertyinfo', property);
  }

  getDashboard(): Observable<Dashboard> {
    let options = {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('token'))
    };
    return this.http.get<Dashboard>('http://localhost:8080/dashboard', options);
  }

  getProperty(propertyId: number): Observable<Property> {
    return this.http.get<Property>('http://localhost:8080/propertyinfo/' + propertyId)
  }
}

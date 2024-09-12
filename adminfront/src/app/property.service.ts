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
     let options = {
          headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('token'))
          ,withCredentials: true
        };
    return this.http.get<PropertyResults>('http://localhost:8080/propertyinfo/propertyinfo?pageNo=' + pageNo, options );
  }

  addProperty(property: Property): Observable<Property> {
         let options = {
              headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('token'))
              ,withCredentials: true
            };
    return this.http.post<Property>('http://localhost:8080/propertyinfo/propertyinfo', property, options);
  }

  getDashboard(): Observable<Dashboard> {
    let options = {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('token'))
      ,withCredentials: true
    };
    return this.http.get<Dashboard>('http://localhost:8080/propertyinfo/propertyinfo/dashboard', options);
  }

  getProperty(propertyId: number): Observable<Property> {
    return this.http.get<Property>('http://localhost:8080/propertyinfo/propertyinfo/' + propertyId)
  }
}

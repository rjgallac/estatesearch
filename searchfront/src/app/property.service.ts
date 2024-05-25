import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Property } from './model/Property'
import { Observable } from 'rxjs';
import { PropertyResults } from './model/PropertyResults';

@Injectable({
  providedIn: 'root'

})
export class PropertyService {


  constructor(private http: HttpClient) { }

  getProperties(search: string, pageNo: number): Observable<PropertyResults> {
    return this.http.get<PropertyResults>('http://localhost:8080/property/searchquery?query=' + search + '&pageNo=' + pageNo);  
  }
}

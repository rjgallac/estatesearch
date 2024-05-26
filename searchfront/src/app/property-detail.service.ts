import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Property } from './model/Property';


@Injectable({
  providedIn: 'root'
})
export class PropertyDetailService {

  constructor(private http: HttpClient) { }

  getDetail(id: number): Observable<Property> {
    return this.http.get<Property>('http://localhost:8082/propertyinfo/' + id);  
  }
}

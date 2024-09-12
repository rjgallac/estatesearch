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
    this.http.get<Property>('http://localhost:8080/imageupload/' + id).subscribe();
    return this.http.get<Property>('http://localhost:8080/propertyinfo/propertyinfo/' + id);  
  }
}

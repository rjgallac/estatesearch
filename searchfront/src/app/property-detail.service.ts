import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PropertyDetailService {

  constructor(private http: HttpClient) { }

  getDetail(): Observable<string> {
    return this.http.get<string>('http://localhost:8090/propertyinfo/1');  
  }
}

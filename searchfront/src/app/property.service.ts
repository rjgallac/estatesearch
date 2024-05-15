import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'

})
export class PropertyService {

  constructor(private http: HttpClient) { }

  getProperties(name: String) {
    return this.http.get('http://localhost:8080/property/searchquery?query=' + name)
      .subscribe((data:any) => console.log(data))
  }
}

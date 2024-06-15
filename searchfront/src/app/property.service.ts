import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Property } from './model/Property'
import { Observable } from 'rxjs';
import { PropertyResults } from './model/PropertyResults';
import { SearchForm } from './model/SearchForm';

@Injectable({
  providedIn: 'root'

})
export class PropertyService {


  constructor(private http: HttpClient) { }

  getProperties(searchForm: SearchForm, pageNo: number): Observable<PropertyResults> {
    return this.http.get<PropertyResults>('http://localhost:8080/search/property/searchquery?query=' 
      + searchForm.name + '&pageNo=' + pageNo + '&minPrice=' + searchForm.minPrice 
      + '&bedrooms=' + searchForm.bedrooms);  
  }
}

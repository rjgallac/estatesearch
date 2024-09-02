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
      let options = {
              headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('token'))
              ,withCredentials: true
            };

    return this.http.get<PropertyResults>('http://localhost:8080/search/property/searchquery?query=' + searchForm.terms
      + '&pageNo=' + pageNo
      + '&type=' + searchForm.type
      + '&propertyType=' + searchForm.houseType
      + '&minPrice=' + searchForm.minPrice
      + '&maxPrice=' + searchForm.maxPrice
      + '&bedrooms=' + searchForm.bedrooms, options);
  }
}

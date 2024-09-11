import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Jwt } from './model/Jwt';
import { View } from './model/View';

@Injectable({
  providedIn: 'root'
})
export class AnalyticsService {

  
  constructor(private http: HttpClient) { }

  view(view: View): Observable<string> {
    return this.http.post<string>('http://localhost:8080/analyticsservice/analytics/view', view );  
  }

  total(): Observable<string> {
    return this.http.get<string>('http://localhost:8080/analyticsservice/analytics/total');  
  }
}

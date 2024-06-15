import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Jwt } from './model/Jwt';
import { Login } from './model/Login';
import { Like } from './model/Like';

@Injectable({
  providedIn: 'root'
})
export class UserdataService {

  constructor(private http: HttpClient) { }

  like(like: Like): Observable<Jwt> {

    let options = {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('token'))
    };
    return this.http.post<Jwt>('http://localhost:8080/userservice/userlikeservice/' + like.userId, like, options );  
  }
}

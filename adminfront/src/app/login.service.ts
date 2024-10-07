import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from './model/Login';
import { Observable } from 'rxjs';
import { Jwt } from './model/jwt';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(login: Login): Observable<Jwt> {

    let body = new URLSearchParams();
    body.set('client_id', 'login-app');
    body.set('username', login.name);
    body.set('password', login.password);
    body.set('grant_type', 'password')

    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
  };
    return this.http.post<Jwt>('http://keycloak:8888/realms/SpringbootKeycloak/protocol/openid-connect/token', body.toString(), options );  
  }
}

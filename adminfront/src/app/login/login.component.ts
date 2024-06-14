import { Component } from '@angular/core';
import { Login } from '../model/Login';
import { FormsModule } from '@angular/forms';
import { MatButton } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { LoginService } from '../login.service';
import { Jwt } from '../model/jwt';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, MatButton, MatFormFieldModule, MatInputModule, MatSelectModule, MatCardModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  providers: [LoginService]
})
export class LoginComponent {

  constructor(private loginService: LoginService) {}

  login: Login = new Login();

  onSubmit() { 
    this.loginService.login(this.login).subscribe((loginResponse: Jwt) => {
      console.log(loginResponse);
      localStorage.setItem('token', loginResponse.access_token);
      // this.router.navigate(['property-detail', property.id])
    });
  }

}

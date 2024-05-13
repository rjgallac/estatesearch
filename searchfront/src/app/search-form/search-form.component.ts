import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { HttpClientModule } from '@angular/common/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-search-form',
  standalone: true,
  imports: [FormsModule,   HttpClientModule],
  templateUrl: './search-form.component.html',
  styleUrl: './search-form.component.css'
})
export class SearchFormComponent {

  constructor(
    private http: HttpClient){}

  search = {
    "name" : ""
  }

  onSubmit() { 
    console.log("HERE"); 
    this.http.get('http://localhost:8080/property/searchquery?query=' + this.search.name).subscribe(data => console.log(data))

  }

}

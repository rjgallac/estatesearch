import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

@Component({
  selector: 'app-search-form',
  standalone: true,
  imports: [FormsModule],
  providers: [],
  templateUrl: './search-form.component.html',
  styleUrl: './search-form.component.css'
})
export class SearchFormComponent {

  constructor(){}

  search = {
    "name" : ""
  }

  onSubmit() { 
    console.log("HERE");     
  }

}

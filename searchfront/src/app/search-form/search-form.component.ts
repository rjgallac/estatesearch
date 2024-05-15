import { Component, EventEmitter, Output } from '@angular/core';
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

  @Output('propertySearch')
  propertySearch: EventEmitter<string> = new EventEmitter<string>();

  constructor(){}

  search = {
    "name" : ""
  }

  onSubmit() { 
    console.log("HERE");
    this.propertySearch.emit(this.search.name) 
  }

}

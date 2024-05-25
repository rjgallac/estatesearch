import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { MatButton} from '@angular/material/button'
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatCardModule} from '@angular/material/card'
import { SearchForm } from '../model/SearchForm';


@Component({
  selector: 'app-search-form',
  standalone: true,
  imports: [FormsModule, MatButton, MatFormFieldModule, MatInputModule, MatSelectModule, MatCardModule],
  providers: [],
  templateUrl: './search-form.component.html',
  styleUrl: './search-form.component.css'
})
export class SearchFormComponent {

  @Output('propertySearch')
  propertySearch: EventEmitter<SearchForm> = new EventEmitter<SearchForm>();

  constructor(){}

  searchForm: SearchForm = new SearchForm();

  onSubmit() { 
    this.propertySearch.emit(this.searchForm) 
  }

}

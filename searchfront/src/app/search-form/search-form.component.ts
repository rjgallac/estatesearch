import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { MatButton} from '@angular/material/button'
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatCardModule} from '@angular/material/card'
import { SearchForm } from '../model/SearchForm';
import {MatTabsModule} from '@angular/material/tabs';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-search-form',
  standalone: true,
  imports: [FormsModule, MatButton, MatFormFieldModule, MatInputModule, MatSelectModule, MatCardModule, MatTabsModule],
  providers: [],
  templateUrl: './search-form.component.html',
  styleUrl: './search-form.component.css'
})
export class SearchFormComponent implements OnInit{

  @Output('propertySearch')
  propertySearch: EventEmitter<SearchForm> = new EventEmitter<SearchForm>();

  constructor(private router: Router, private route: ActivatedRoute){}

  @Input('searchForm')
  searchForm: SearchForm = new SearchForm();

  ngOnInit(): void {
    this.searchForm.type = this.route.snapshot.queryParamMap.get('type')!;
    if(this.route.snapshot.queryParamMap.get('houseType') != null) {
      this.searchForm.houseType = this.route.snapshot.queryParamMap.get('houseType')!;
    }
    if(this.route.snapshot.queryParamMap.get('bedrooms') != null) {
      this.searchForm.bedrooms = this.route.snapshot.queryParamMap.get('bedrooms')!;
    }
    this.searchForm.type = this.route.snapshot.queryParamMap.get('type')!;
    if(this.route.snapshot.queryParamMap.get('minPrice') != null) {
      this.searchForm.minPrice = this.route.snapshot.queryParamMap.get('minPrice')!;
    }
    if(this.route.snapshot.queryParamMap.get('terms') !== null) {
      this.searchForm.terms = this.route.snapshot.queryParamMap.get('terms')!;
    }
    this.propertySearch.emit(this.searchForm);
  }

  onSubmit() { 
    // if on search page perform search 
    if(this.router.url.startsWith('/search')) {
      this.propertySearch.emit(this.searchForm);
      this.router.navigate(["search"], {
        queryParams: {
          type: this.searchForm.type,
          houseType: this.searchForm.houseType,
          minPrice: this.searchForm.minPrice,
          maxPrice: this.searchForm.maxPrice,
          bedrooms: this.searchForm.bedrooms,
          terms: this.searchForm.terms
        },
        skipLocationChange: false
      })
    } else {
      // if on home page navigate away
      this.router.navigate(["search"], {
        queryParams: {
          type: this.searchForm.type,
          houseType: this.searchForm.houseType,
          minPrice: this.searchForm.minPrice,
          maxPrice: this.searchForm.maxPrice,
          bedrooms: this.searchForm.bedrooms,
          terms: this.searchForm.terms
        },
        skipLocationChange: false
      })
    }
  }

}

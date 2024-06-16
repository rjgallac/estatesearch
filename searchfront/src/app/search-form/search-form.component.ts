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
import { merge } from 'rxjs';


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
    // this.route.paramMap.subscribe(params => {
    //   this.searchForm.type = params.get('type')!;
    //   this.searchForm.minPrice = Number(params.get('minPrice')!);
    //   this.searchForm.bedrooms = Number(params.get('bedrooms')!);
    //   this.searchForm.type = params.get('type')!;
    //   console.log("init")
    //   // console.log(this.propertyId);
    //   // this.propertyDetailService.getDetail(this.propertyId).subscribe((property: Property) =>{
    //   //   this.property = property;
    //   // });
    //   // let view: View = new View();
    //   // view.propertyId = this.propertyId;
    //   // this.analyticsService.view(view).subscribe();
    // });

    this.searchForm.type = this.route.snapshot.queryParamMap.get('type')!;
    this.searchForm.houseType = this.route.snapshot.queryParamMap.get('houseType')!;
    this.searchForm.bedrooms = this.route.snapshot.queryParamMap.get('bedrooms')!;
    this.searchForm.type = this.route.snapshot.queryParamMap.get('type')!;
    this.searchForm.minPrice = this.route.snapshot.queryParamMap.get('minPrice')!;
    this.searchForm.terms = this.route.snapshot.queryParamMap.get('terms')!;

    console.log(this.searchForm.minPrice)
    this.propertySearch.emit(this.searchForm) 

  }

  onSubmit() { 
    console.log("nav")
    this.router.navigate([""], {
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
    console.log("HERE")
    this.propertySearch.emit(this.searchForm) 

  }

}

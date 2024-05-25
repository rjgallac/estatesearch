import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { DetailViewComponent } from './detail-view/detail-view.component'
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule, CommonModule, DetailViewComponent, RouterLink],
  providers: [],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  title = 'searchfront';


  constructor(){}

}

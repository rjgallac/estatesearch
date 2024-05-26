import { Component, ViewChild, AfterViewInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatSidenav } from '@angular/material/sidenav';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { RouterModule } from '@angular/router';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { SidenavComponent } from '../sidenav/sidenav.component';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [
    CommonModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatIconModule,
    MatButtonModule,
    RouterModule,
    SidenavComponent
  ],
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements AfterViewInit {
  @ViewChild('sidenav') sidenav!: MatSidenav;

  constructor(private breakpointObserver: BreakpointObserver) {}

  ngAfterViewInit() {
    // This will set the mode to 'over' and close the sidenav by default.
    this.sidenav.mode = 'over';
    this.sidenav.close();
  }

  toggleSidenav() {
    this.sidenav.toggle();
  }
}

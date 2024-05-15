import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertyResultComponent } from './property-result.component';

describe('PropertyResultComponent', () => {
  let component: PropertyResultComponent;
  let fixture: ComponentFixture<PropertyResultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PropertyResultComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PropertyResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

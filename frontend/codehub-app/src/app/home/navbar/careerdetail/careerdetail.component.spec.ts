import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CareerdetailComponent } from './careerdetail.component';

describe('CareerdetailComponent', () => {
  let component: CareerdetailComponent;
  let fixture: ComponentFixture<CareerdetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CareerdetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CareerdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

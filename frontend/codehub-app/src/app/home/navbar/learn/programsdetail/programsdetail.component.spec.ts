import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgramsdetailComponent } from './programsdetail.component';

describe('ProgramsdetailComponent', () => {
  let component: ProgramsdetailComponent;
  let fixture: ComponentFixture<ProgramsdetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProgramsdetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgramsdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TheProgressComponent } from './the-progress.component';

describe('TheProgressComponent', () => {
  let component: TheProgressComponent;
  let fixture: ComponentFixture<TheProgressComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TheProgressComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TheProgressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

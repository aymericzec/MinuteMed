import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultprescriptionComponent } from './consultprescription.component';

describe('ConsultprescriptionComponent', () => {
  let component: ConsultprescriptionComponent;
  let fixture: ComponentFixture<ConsultprescriptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultprescriptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultprescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultPrescriptionComponent } from './consult-prescription.component';

describe('ConsultPrescriptionComponent', () => {
  let component: ConsultPrescriptionComponent;
  let fixture: ComponentFixture<ConsultPrescriptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultPrescriptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultPrescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

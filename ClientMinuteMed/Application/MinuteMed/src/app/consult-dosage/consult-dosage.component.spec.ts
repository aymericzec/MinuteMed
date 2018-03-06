import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultDosageComponent } from './consult-dosage.component';

describe('ConsultDosageComponent', () => {
  let component: ConsultDosageComponent;
  let fixture: ComponentFixture<ConsultDosageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultDosageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultDosageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

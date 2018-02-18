import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultdiagnosticComponent } from './consultdiagnostic.component';

describe('ConsultdiagnosticComponent', () => {
  let component: ConsultdiagnosticComponent;
  let fixture: ComponentFixture<ConsultdiagnosticComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultdiagnosticComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultdiagnosticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

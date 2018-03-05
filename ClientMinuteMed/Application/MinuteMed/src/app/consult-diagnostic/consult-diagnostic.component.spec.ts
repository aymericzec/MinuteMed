import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultDiagnosticComponent } from './consult-diagnostic.component';

describe('ConsultDiagnosticComponent', () => {
  let component: ConsultDiagnosticComponent;
  let fixture: ComponentFixture<ConsultDiagnosticComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultDiagnosticComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultDiagnosticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

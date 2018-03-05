import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDiagnosticComponent } from './create-diagnostic.component';

describe('CreateDiagnosticComponent', () => {
  let component: CreateDiagnosticComponent;
  let fixture: ComponentFixture<CreateDiagnosticComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateDiagnosticComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateDiagnosticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatediagnosticComponent } from './creatediagnostic.component';

describe('CreatediagnosticComponent', () => {
  let component: CreatediagnosticComponent;
  let fixture: ComponentFixture<CreatediagnosticComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatediagnosticComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatediagnosticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

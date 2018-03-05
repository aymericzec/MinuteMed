import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultExamComponent } from './consult-exam.component';

describe('ConsultExamComponent', () => {
  let component: ConsultExamComponent;
  let fixture: ComponentFixture<ConsultExamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultExamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

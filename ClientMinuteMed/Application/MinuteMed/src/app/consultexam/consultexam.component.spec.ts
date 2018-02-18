import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultexamComponent } from './consultexam.component';

describe('ConsultexamComponent', () => {
  let component: ConsultexamComponent;
  let fixture: ComponentFixture<ConsultexamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultexamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultexamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

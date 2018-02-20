import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeftnavbardoctorComponent } from './leftnavbardoctor.component';

describe('LeftnavbardoctorComponent', () => {
  let component: LeftnavbardoctorComponent;
  let fixture: ComponentFixture<LeftnavbardoctorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeftnavbardoctorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeftnavbardoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

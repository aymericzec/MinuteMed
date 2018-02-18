import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultposologieComponent } from './consultposologie.component';

describe('ConsultposologieComponent', () => {
  let component: ConsultposologieComponent;
  let fixture: ComponentFixture<ConsultposologieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultposologieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultposologieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

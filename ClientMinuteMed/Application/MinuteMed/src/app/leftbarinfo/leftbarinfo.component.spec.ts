import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeftbarinfoComponent } from './leftbarinfo.component';

describe('LeftbarinfoComponent', () => {
  let component: LeftbarinfoComponent;
  let fixture: ComponentFixture<LeftbarinfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeftbarinfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeftbarinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

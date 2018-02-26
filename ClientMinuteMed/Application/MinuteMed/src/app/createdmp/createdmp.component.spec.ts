import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatedmpComponent } from './createdmp.component';

describe('CreatedmpComponent', () => {
  let component: CreatedmpComponent;
  let fixture: ComponentFixture<CreatedmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatedmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatedmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

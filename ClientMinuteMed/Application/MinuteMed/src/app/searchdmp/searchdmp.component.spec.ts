import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDmpComponent } from './searchdmp.component';

describe('SearchDmpComponent', () => {
  let component: SearchDmpComponent;
  let fixture: ComponentFixture<SearchDmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchDmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

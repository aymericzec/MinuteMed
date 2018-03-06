import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDosagesComponent } from './search-dosages.component';

describe('SearchDosagesComponent', () => {
  let component: SearchDosagesComponent;
  let fixture: ComponentFixture<SearchDosagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchDosagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDosagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

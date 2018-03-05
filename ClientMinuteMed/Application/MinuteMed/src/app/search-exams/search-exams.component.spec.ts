import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchExamsComponent } from './search-exams.component';

describe('SearchExamsComponent', () => {
  let component: SearchExamsComponent;
  let fixture: ComponentFixture<SearchExamsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchExamsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchExamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

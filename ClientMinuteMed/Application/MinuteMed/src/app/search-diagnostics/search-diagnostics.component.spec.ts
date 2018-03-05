import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDiagnosticsComponent } from './search-diagnostics.component';

describe('SearchDiagnosticsComponent', () => {
  let component: SearchDiagnosticsComponent;
  let fixture: ComponentFixture<SearchDiagnosticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchDiagnosticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDiagnosticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

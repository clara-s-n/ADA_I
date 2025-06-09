import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalaDetailComponent } from './sala-detail.component';

describe('SalaDetailComponent', () => {
  let component: SalaDetailComponent;
  let fixture: ComponentFixture<SalaDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SalaDetailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalaDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

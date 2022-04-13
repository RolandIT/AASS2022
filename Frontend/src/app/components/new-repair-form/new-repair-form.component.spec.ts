import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewRepairFormComponent } from './new-repair-form.component';

describe('NewRepairFormComponent', () => {
  let component: NewRepairFormComponent;
  let fixture: ComponentFixture<NewRepairFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewRepairFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewRepairFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

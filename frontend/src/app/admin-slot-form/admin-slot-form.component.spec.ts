import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSlotFormComponent } from './admin-slot-form.component';

describe('AdminSlotFormComponent', () => {
  let component: AdminSlotFormComponent;
  let fixture: ComponentFixture<AdminSlotFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminSlotFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminSlotFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

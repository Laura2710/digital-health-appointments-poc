import { Component } from '@angular/core';

import { CommonModule } from '@angular/common';
import { AdminSlotFormComponent } from './admin-slot-form/admin-slot-form.component';

@Component({
  selector: 'app-admin-page',
  standalone: true,
  imports: [CommonModule, AdminSlotFormComponent],
  templateUrl: './admin-page.component.html',
})
export class AdminPageComponent {}

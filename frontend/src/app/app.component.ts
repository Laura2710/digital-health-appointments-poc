import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SlotListComponent } from './slots/slot-list/slot-list.component';
import { AdminSlotFormComponent } from './admin-slot-form/admin-slot-form.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SlotListComponent, AdminSlotFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'frontend';
}

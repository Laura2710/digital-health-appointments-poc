import { Component } from '@angular/core';
import { SlotListComponent } from '../../slots/slot-list/slot-list.component';

@Component({
  selector: 'app-patient-page',
  imports: [SlotListComponent],
  templateUrl: './patient-page.component.html',
  styleUrl: './patient-page.component.css',
})
export class PatientPageComponent {}

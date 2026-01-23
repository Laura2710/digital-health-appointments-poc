import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SlotService } from '../../../services/slot.service';

@Component({
  selector: 'app-admin-slot-form',
  imports: [FormsModule],
  templateUrl: './admin-slot-form.component.html',
  styleUrl: './admin-slot-form.component.css',
})
export class AdminSlotFormComponent {
  date = '';
  startTime = '';
  endTime = '';

  constructor(private readonly slotService: SlotService) {}

  submit() {
    const start = `${this.date}T${this.startTime}:00`;
    const end = `${this.date}T${this.endTime}:00`;

    this.slotService.createSlot(start, end).subscribe({
      next: () => {
        alert('Créneau créé');
        this.resetForm();
      },
      error: (err) => {
        alert(err.error);
      },
    });
  }

  resetForm() {
    this.date = '';
    this.startTime = '';
    this.endTime = '';
  }
}

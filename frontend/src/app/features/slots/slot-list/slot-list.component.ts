import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Slot, SlotService } from '../../../services/slot.service';
import { filter, map } from 'rxjs';
@Component({
  selector: 'app-slot-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './slot-list.component.html',
  styleUrl: './slot-list.component.css',
})
export class SlotListComponent implements OnInit {
  slots: Slot[] = [];

  constructor(private readonly slotService: SlotService) {}

  ngOnInit(): void {
    this.loadSlots();
  }

  loadSlots() {
    const now = new Date();

    this.slotService
      .getSlots()
      .pipe(
        map((slots) => slots.filter((slot) => new Date(slot.startTime) > now)),
      )
      .subscribe((slots) => (this.slots = slots));
  }

  reserve(id: string) {
    this.slotService.reserveSlot(id).subscribe({
      next: () => this.loadSlots(),
      error: (err) => alert(err.error),
    });
  }

  getDurationMinutes(start: string, end: string): number {
    const diffMs = new Date(end).getTime() - new Date(start).getTime();
    return diffMs / 60000;
  }
}

import { Component, OnInit } from '@angular/core';
import { Slot, SlotService } from '../../services/slot.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-slot-list',
  imports: [CommonModule],
  templateUrl: './slot-list.component.html',
  styleUrl: './slot-list.component.css',
})
export class SlotListComponent implements OnInit {
  slots: Slot[] = [];

  constructor(private readonly slotService: SlotService) {}
  ngOnInit(): void {
    this.slotService.getSlots().subscribe((slots) => (this.slots = slots));
  }

  getDurationMinutes(start: string, end: string): number {
    const startDate = new Date(start);
    const endDate = new Date(end);

    const diffMs = endDate.getTime() - startDate.getTime();
    return diffMs / 60000;
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Slot {
  // contrat identique au backend
  id: string;
  startTime: string;
  endTime: string;
  reserved: boolean;
}

@Injectable({
  providedIn: 'root',
})
export class SlotService {
  private readonly api = 'http://localhost:8080/api/slots';
  constructor(private readonly http: HttpClient) {}

  getSlots(): Observable<Slot[]> {
    return this.http.get<Slot[]>(this.api);
  }

  createSlot(startTime: string, endTime: string): Observable<any> {
    return this.http.post(this.api, {
      startTime,
      endTime,
    });
  }
}

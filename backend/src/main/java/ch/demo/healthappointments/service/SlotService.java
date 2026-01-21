package ch.demo.healthappointments.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import ch.demo.healthappointments.model.Slot;

@Service
public class SlotService {
    public List<Slot> getAllSlots() {
       return List.of(
            new Slot(UUID.randomUUID(), LocalDateTime.now().plusHours(1), false),
            new Slot(UUID.randomUUID(), LocalDateTime.now().plusHours(2),  false)
       );
    }
}

package ch.demo.healthappointments.service;

import org.springframework.stereotype.Service;

import ch.demo.healthappointments.model.Slot;
import ch.demo.healthappointments.repository.SlotRepository;
import reactor.core.publisher.Flux;

@Service
public class SlotService {

    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }
     public Flux<Slot> getAllSlots() {
        return slotRepository.findAll();
    }
}

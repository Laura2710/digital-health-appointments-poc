package ch.demo.healthappointments.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import ch.demo.healthappointments.dto.SlotCreateRequest;
import ch.demo.healthappointments.model.Slot;
import ch.demo.healthappointments.repository.SlotRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SlotService {

    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }
     public Flux<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    public Mono<Slot> createSlot(SlotCreateRequest request) {
        if (request.getEndTime().isBefore(request.getStartTime())) {
            return Mono.error(new IllegalArgumentException("endTime must be after startTime"));
        }

        Slot slot = new Slot(
            null,
            request.getStartTime(),
            request.getEndTime(),
            false
        );
    
        return slotRepository.save(slot);
    }
}

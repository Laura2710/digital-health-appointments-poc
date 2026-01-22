package ch.demo.healthappointments.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import ch.demo.healthappointments.dto.SlotCreateRequest;
import ch.demo.healthappointments.model.Slot;
import ch.demo.healthappointments.repository.SlotRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Service métier de gestion des créneaux.
 * Toutes les données manipulées sont fictives (POC).
 * Aucune donnée patient réelle n'est traitée.
 */
@Service
public class SlotService {

    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }
     public Flux<Slot> getAllSlots() {
        return slotRepository.findAllByOrderByStartTimeAsc();
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

    public Mono<Slot> reserveSlot(UUID slotId) {
        return slotRepository.findById(slotId)
            .switchIfEmpty(Mono.error(new IllegalArgumentException("Créneau introuvable")))
            .flatMap(slot -> {
                if (slot.isReserved()) {
                    return Mono.error(new IllegalStateException("Créneau déjà réservé"));
                }

                slot.setReserved(true);
                return slotRepository.save(slot);
            });
    }

}

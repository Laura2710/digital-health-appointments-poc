package ch.demo.healthappointments.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.demo.healthappointments.dto.SlotCreateRequest;
import ch.demo.healthappointments.model.Slot;
import ch.demo.healthappointments.service.SlotService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/slots")
public class SlotController {
    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping
    public Flux<Slot> getSlots() {
        return slotService.getAllSlots().filter(slot->!slot.isReserved());
    }

    @PostMapping("/{id}/reserve")
    public Mono<Slot> reserveSlot(@PathVariable UUID id) {
        return slotService.reserveSlot(id);
    }
    
}

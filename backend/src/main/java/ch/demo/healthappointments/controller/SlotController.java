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
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/slots")
public class SlotController {
    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping
    public Flux<Slot> getSlots() {
        return slotService.getAllSlots();
    }

@PostMapping
public Mono<Slot> createSlot(@RequestBody SlotCreateRequest request) {
    return slotService.createSlot(request);
}

    @PostMapping("/ping")
    public Mono<String> ping() {
        return Mono.just("pong");
    }
    
    @PostMapping("/{id}/reserve")
    public Mono<Slot> reserveSlot(@PathVariable UUID id) {
        return slotService.reserveSlot(id);
    }
    
}

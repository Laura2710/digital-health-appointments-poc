package ch.demo.healthappointments.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.demo.healthappointments.dto.SlotCreateRequest;
import ch.demo.healthappointments.model.Slot;
import ch.demo.healthappointments.service.SlotService;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/api/admin/slots")
public class AdminSlotController {
      private final SlotService slotService;

    public AdminSlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping
    public Mono<Slot> createSlot(@Valid @RequestBody SlotCreateRequest request) {
        return slotService.createSlot(request);
    }
}

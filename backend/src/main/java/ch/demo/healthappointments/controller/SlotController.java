package ch.demo.healthappointments.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.demo.healthappointments.model.Slot;
import ch.demo.healthappointments.service.SlotService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/slots")
public class SlotController {
    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping
    public List<Slot> getSlots() {
        return slotService.getAllSlots();
    }
    
}

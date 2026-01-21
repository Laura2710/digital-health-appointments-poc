package ch.demo.healthappointments.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import ch.demo.healthappointments.model.Slot;

public interface SlotRepository extends ReactiveCrudRepository<Slot, UUID> {
    
}

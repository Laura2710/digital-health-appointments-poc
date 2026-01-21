package ch.demo.healthappointments.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import ch.demo.healthappointments.model.Slot;
import reactor.core.publisher.Flux;

public interface SlotRepository extends ReactiveCrudRepository<Slot, UUID> {
    Flux<Slot> findAllByOrderByStartTimeAsc();
}

package ch.demo.healthappointments.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import ch.demo.healthappointments.model.User;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
    Mono<User> findByUsername(String username);
} 
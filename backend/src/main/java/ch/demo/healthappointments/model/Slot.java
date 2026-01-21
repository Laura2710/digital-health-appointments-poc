package ch.demo.healthappointments.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Slot {
    private UUID id;
    private LocalDateTime startTime;
    private boolean reserved;

    public Slot(UUID id, LocalDateTime startTime, boolean reserved) {
        this.id = id;
        this.startTime = startTime;
        this.reserved = reserved;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public boolean isReserved() {
        return reserved;
    }
}

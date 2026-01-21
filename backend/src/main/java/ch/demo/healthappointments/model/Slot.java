package ch.demo.healthappointments.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("slots")
public class Slot {

    @Id
    private UUID id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private boolean reserved;

    public Slot() {
    }

    public Slot(UUID id, LocalDateTime startTime, LocalDateTime endTime, boolean reserved) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reserved = reserved;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}

package ch.demo.healthappointments.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class SlotCreateRequest {

    @NotNull(message = "Start time is required")
    private LocalDateTime startTime;
    @NotNull(message = "End time is required")
    private LocalDateTime endTime;

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
}

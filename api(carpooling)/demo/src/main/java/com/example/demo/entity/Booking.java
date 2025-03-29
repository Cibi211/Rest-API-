package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Booking {

    @Id
    @Min(1)
    private Long id;

    @NotNull(message = "Start date cannot be null")
    @FutureOrPresent(message = "Start date must be today or in the future")
    private LocalDateTime startDate;

    @NotNull(message = "End date cannot be null")
    private LocalDateTime endDate;

    private Double totalAmount;
    private Double insuranceIncluded;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    @JsonIgnoreProperties("bookings")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PostPersist
    @PostUpdate
    private void validateDates() {
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date must be equal to or after the start date.");
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getInsuranceIncluded() {
        return insuranceIncluded;
    }

    public void setInsuranceIncluded(Double insuranceIncluded) {
        this.insuranceIncluded = insuranceIncluded;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

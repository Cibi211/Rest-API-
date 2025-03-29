package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
// import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String licensePlate;
    @ManyToOne
    @JoinColumn(name = "rental_company_id")
    @JsonBackReference // Prevents infinite recursion during serialization
    private Rentalcompany rentalCompany;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
     @JsonIgnoreProperties({"vehicle", "user"}) 
    private List<Booking> bookings;

    // @ManyToOne
    // @JoinColumn(name = "rental_company_id")
    // private Rentalcompany rentalCompany;

    // @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    // private List<Booking> bookings;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public Rentalcompany getRentalCompany() { return rentalCompany; }
    public void setRentalCompany(Rentalcompany rentalCompany) { this.rentalCompany = rentalCompany; }

    public List<Booking> getBookings() { return bookings; }
    public void setBookings(List<Booking> bookings) { this.bookings = bookings; }
}

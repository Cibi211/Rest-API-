package com.example.demo.entity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Rentalcompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "rentalCompany", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles = new ArrayList<>();

    // Helper method to get all bookings through vehicles
    public List<Booking> getAllBookings() {
        return vehicles.stream()
                       .flatMap(vehicle -> vehicle.getBookings().stream())
                       .collect(Collectors.toList());
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Vehicle> getVehicles() { return vehicles; }
    public void setVehicles(List<Vehicle> vehicles) { this.vehicles = vehicles; }
}




// import jakarta.persistence.*;

// import java.util.ArrayList;
// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonIdentityInfo;
// // import com.fasterxml.jackson.annotation.JsonManagedReference;
// import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// @Entity
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
// public class Rentalcompany {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//     private String location;

//     @OneToMany(mappedBy = "rentalCompany", cascade = CascadeType.ALL)
//     private List<Vehicle> vehicles= new ArrayList<>();

    
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getLocation() {
//         return location;
//     }

//     public void setLocation(String location) {
//         this.location = location;
//     }

//     public List<Vehicle> getVehicles() {
//         return vehicles;
//     }

//     public void setVehicles(List<Vehicle> vehicles) {
//         this.vehicles = vehicles;
//     }
// }

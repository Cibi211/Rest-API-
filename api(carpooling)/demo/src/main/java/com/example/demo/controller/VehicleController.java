package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;

@RestController

public class VehicleController {
    @Autowired
    VehicleService vs;

    
    @PostMapping("vehpost")
public List<Vehicle> createVehicles(@RequestBody List<Vehicle> vehicles) {
    return vs.addveh(vehicles);
}


    // public List<Vehicle> createVehicles(@RequestBody List<Vehicle> vehicles) {
    //     return vs.addveh(vehicles);
    // }

    @GetMapping("/vehget")
    public List<Vehicle> display()

    {
        return vs.displayveh();
    }

    @PutMapping("/vehput/{id}")
    public Vehicle updateveh(@PathVariable Long id, @RequestBody Vehicle u1) {
        return vs.updatevehr(id, u1);
    }

    @DeleteMapping("/vehdel/{id}")
    public String deletevehicle(@PathVariable Long id) {
        return vs.deleteveh(id);

    }

    @GetMapping("/vehpage")
    public Page<Vehicle> getByPage(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return vs.getvehByPage(page, size);
    }

    @GetMapping("/vehsort")
    public List<Vehicle> sortByUser() {
        return vs.sortbyveh();
    }
}

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

import com.example.demo.entity.Rentalcompany;
import com.example.demo.service.RentalcompanyService;

@RestController

public class RentalcompanyController {
    @Autowired
    RentalcompanyService rs;

    @PostMapping("/rcpost")
    public Rentalcompany createRenatl(@RequestBody Rentalcompany rc)
    {
        return rs.addrc(rc);
    }
     @GetMapping("/rcget")
    public List<Rentalcompany> displayuser()
    {
        return rs.display();
    }
     @PutMapping("/rcput/{id}")
    public Rentalcompany updaterent(@PathVariable Long id, @RequestBody Rentalcompany u1) {
        return rs.updaterc(id, u1);
    }
      @DeleteMapping("/rcdel/{id}")
    public String deleteEmployee(@PathVariable Long id)
    {
        return rs.deleterc(id);
    
    }


    //pagination
     @GetMapping("/rcpage")
    public Page<Rentalcompany>getByPage(@RequestParam (defaultValue="0") int page,@RequestParam (defaultValue="5") int size){
        return rs.getRentpage(page, size);
    }

    //sorting
    @GetMapping("/rcsort")
    public List<Rentalcompany>sortbyrent()
    {
        return rs.sortbyrc();
    }

    //Jpql
    @GetMapping("/rcq/{make}")
    public List<Rentalcompany>getrcQuery(String name){
        return rs.getByQueryrc(name);
    }

    
    
}

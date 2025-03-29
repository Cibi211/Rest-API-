package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;

@Service

public class VehicleService {
    @Autowired

    VehicleRepository vr;

    //post
    public List<Vehicle> addveh(List<Vehicle> v1)
    {
        return vr.saveAll(v1);

        //get
    }
    public List<Vehicle> displayveh()
    {
        return vr.findAll();
    }

    //put
    public Vehicle updatevehr(long id,Vehicle u1){
        u1.setId(id);
        return vr.save(u1);
     }

    //delete
    public String deleteveh(Long id)
     {
       vr.deleteById(id);
        return "Success deleted the Vehicle";
     }

    //pagination
    public Page<Vehicle> getvehByPage(int page,int size)
    {
        Pageable pageable= PageRequest.of(page,size);
        return vr.findAll(pageable);
    }
   
      //sort
      public List<Vehicle>sortbyveh()
      {
         return vr.findAll(Sort.by(Sort.Direction.DESC,"make"));
      }

     



    
    
}

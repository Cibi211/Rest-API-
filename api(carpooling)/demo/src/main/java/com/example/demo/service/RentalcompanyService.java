package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Rentalcompany;
import com.example.demo.repository.RenatlcompanyRepository;

@Service

public class RentalcompanyService {
    @Autowired

    RenatlcompanyRepository rr;
   
     public Rentalcompany addrc(Rentalcompany u1)
     {
        return rr.save(u1);
     }
     public List<Rentalcompany> display()
     {
        return rr.findAll();
     }

     public Rentalcompany updaterc(long id,Rentalcompany u1){
        u1.setId(id);
        return rr.save(u1);
     }

     public String deleterc(Long id)
     {
       rr.deleteById(id);
        return "Success";
     }

     //pagination
     public Page<Rentalcompany> getRentpage(int page,int size){
      Pageable rcpage=PageRequest.of(page,size);
      return rr.findAll(rcpage);

   }
      //sort
      public List<Rentalcompany>sortbyrc()
      {
         return rr.findAll(Sort.by(Sort.Direction.DESC,"name"));
      }

      //JpqlQuery
         public List<Rentalcompany>getByQueryrc(String name)
      {
          return rr.findByUsernamerc(name);
      }

     
      
   


}

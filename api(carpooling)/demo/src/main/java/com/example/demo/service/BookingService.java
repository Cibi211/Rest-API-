package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;

@Service
public class BookingService {
    @Autowired
    BookingRepository br;

      public Booking book(Booking b1)
    {
        return br.save(b1);
    }

     public List<Booking> displaybk()
     {
        return br.findAll();
     }

      public Booking updatebk(long id,Booking u1){
        u1.setId(id);
        return br.save(u1);
     }

     public String deletebk(Long id){
      br.deleteById(id);
      return "Id has deleted Successfully";
     }
     
     public Page<Booking> getbkPage(int page,int size){
      Pageable pbk=PageRequest.of(page,size);
      return br.findAll(pbk);
     }

     //sort
     public List<Booking>sortbook()
     {
      return br.findAll(Sort.by(Sort.Direction.ASC,"endDate"));
     }







    
}

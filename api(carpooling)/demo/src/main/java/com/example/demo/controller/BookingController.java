package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;

import jakarta.validation.Valid;

@RestController


public class BookingController {
    @Autowired

    BookingService bs;

    @PostMapping("/bkpost")
    public ResponseEntity<?> createBooking(@Valid @RequestBody Booking booking) {
        try {
            if (booking.getId() == null || booking.getId() <= 0) {
                return ResponseEntity.badRequest().body("ID must be a positive number greater than 0.");
            }
            if (booking.getStartDate().isBefore(LocalDateTime.now())) {
                return ResponseEntity.badRequest().body("Start date must be today or later.");
            }
            if (booking.getEndDate().isBefore(booking.getStartDate())) {
                return ResponseEntity.badRequest().body("End date must be equal to or after the start date.");
            }
            
            Booking savedBooking = bs.book(booking);
            return ResponseEntity.ok(savedBooking);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
   
    @GetMapping("/bkget")
    public List<Booking> displaybook()
    {
        return bs.displaybk();
    }
    @PutMapping("/bkput/{id}")
    public Booking update(@PathVariable Long id, @RequestBody Booking u1) {
        return bs.updatebk(id, u1);
    }
    
    @DeleteMapping("bkdel/{id}")
    public String deletebook(@PathVariable Long id){
        return bs.deletebk(id);
    }

    //pagination
    @GetMapping("/bkpage")
    public Page<Booking> bookpage(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "5")int size){
        return bs.getbkPage(page, size);
    }

    //sort
    @GetMapping("/bksort")
    public List<Booking>sortbk()
    {
        return bs.sortbook();
    }

}

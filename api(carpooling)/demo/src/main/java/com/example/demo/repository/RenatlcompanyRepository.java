package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Rentalcompany;

@Repository
public interface RenatlcompanyRepository extends JpaRepository<Rentalcompany,Long> {
    @Query("SELECT q from Rentalcompany q WHERE q.name LIKE %:name%")
List<Rentalcompany> findByUsernamerc(@Param("name") String name);
    
}

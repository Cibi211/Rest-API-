package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired

    UserRepository ur;
    public User addUser(User u1) {
      if (ur.existsByName(u1.getName())) {  // ✅ Check if name already exists
          throw new RuntimeException("User with this name already exists. Please use a different name.");
      }
      return ur.save(u1);
  }
   
     public List<User> display()
     {
        return ur.findAll();
     }

     public User updateuser(long id,User u1){
        u1.setId(id);
        return ur.save(u1);
     }

     public String deleteuser(Long id)
     {
       ur.deleteById(id);
        return "Success";
     }
     
      public Page<User> getUserByPage(int page,int size)
    {
        Pageable pageable= PageRequest.of(page,size);
        return ur.findAll(pageable);
    }
    public List<User>sortByUser()
    {
       return ur.findAll(Sort.by(Sort.Direction.DESC,"id"));
      }

      public List<User>getByQuery(String name)
      {
          return ur.findByUsername(name);
      }
//jpa
      public List<User>getByEmail(String email){
         return ur.findByemail(email);
      }
    
}

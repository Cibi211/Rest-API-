package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;

@RestController
@Validated 
public class UserController {

    @Autowired
    UserService us;

    @PostMapping("/vovo")
    public ResponseEntity<?> createUser(@Valid @RequestBody User u1) {  
        try {
            // Custom validation for email
            if (!u1.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$")) {
                return ResponseEntity.badRequest().body("Invalid email format. Email must contain '@' and end with '.com'");
            }
            
            User savedUser = us.addUser(u1);
            return ResponseEntity.ok(savedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    // @PostMapping("/vovo")
    // public ResponseEntity<?> createUser(@Valid @RequestBody User u1) {  // ✅ Change return type to ResponseEntity<?>
    //     try {
    //         // Custom validation for email
    //         if (!u1.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$")) {
    //             return ResponseEntity.badRequest().body("Invalid email format. Email must contain '@' and end with '.com'");
    //         }
            
    //         User savedUser = us.addUser(u1);
    //         return ResponseEntity.ok(savedUser);
    //     } catch (RuntimeException e) {
    //         return ResponseEntity.badRequest().body(e.getMessage());
    //     }
    // }
    

    @GetMapping("/gogo")
    public List<User> displayuser() {
        return us.display();
    }

    @GetMapping("/page")
    public Page<User> getByPage(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size) {
        return us.getUserByPage(page, size);
    }

    @GetMapping("/sort")
    public List<User> sortByUser() {
        return us.sortByUser();
    }

    @PutMapping("/gogo/{id}")
    public ResponseEntity<?> updateuser(@PathVariable Long id, @Valid @RequestBody User u1) {
        try {
            User updatedUser = us.updateuser(id, u1);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {
            String result = us.deleteuser(id);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/qu/{name}")
    public List<User> getUsername(@PathVariable String name) {
        return us.getByQuery(name);
    }

    @GetMapping("/custom/{email}")
    public ResponseEntity<?> findByemail(@PathVariable String email) {
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$")) {
            return ResponseEntity.badRequest().body("Invalid email format. Email must contain '@' and end with '.com'");
        }
        return ResponseEntity.ok(us.getByEmail(email));
    }
}

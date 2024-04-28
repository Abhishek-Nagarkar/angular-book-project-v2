package com.demo.resttutorial.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.resttutorial.layer2.Burger;
import com.demo.resttutorial.layer4.BurgerService;

@RestController
@RequestMapping("/McD")
@CrossOrigin("http://localhost:4200")
public class BurgerController {

    @Autowired
    private BurgerService burgerSvc; // loose coupling

    @PostMapping("/add")
    public ResponseEntity addBurger(@RequestBody Burger burger) {
        try {
            burgerSvc.addBurger(burger);
            return ResponseEntity.status(HttpStatus.OK).body("Burger added successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findBurger(@PathVariable("id") int burgerId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(burgerSvc.findBurger(burgerId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity findAllBurgers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(burgerSvc.findAllBurgers());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateBurger(@RequestBody Burger burger) {
        try {
            burgerSvc.updateBurger(burger);
            return ResponseEntity.status(HttpStatus.OK).body("Burger updated successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBurger(@PathVariable("id") int burgerId) {
        try {
            burgerSvc.deleteBurger(burgerId);
            return ResponseEntity.status(HttpStatus.OK).body("Burger deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}

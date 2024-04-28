package com.demo.resttutorial.layer2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Burger {
    
    // pojo - all fields are private
    //      - default / param constructor
    //      - getters and setters

    @Id
    @Column(name="burgerId")
    private int burgerId;
    @Column(name="burgerPrice")
    private int price;
    @Column(name="burgerName")
    private String name;
    
}

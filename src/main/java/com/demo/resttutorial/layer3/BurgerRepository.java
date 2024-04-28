package com.demo.resttutorial.layer3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.resttutorial.layer2.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger,Integer> {
    
}

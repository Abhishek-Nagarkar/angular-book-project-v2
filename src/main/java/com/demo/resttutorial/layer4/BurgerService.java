package com.demo.resttutorial.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.resttutorial.layer2.Burger;

@Service
public interface BurgerService {
    // create
    void addBurger(Burger burger);

    // read
    Burger findBurger(int burgerId);

    // read all
    List<Burger> findAllBurgers();

    // update
    void updateBurger(Burger burger);

    // delete
    void deleteBurger(int burgerId);
}

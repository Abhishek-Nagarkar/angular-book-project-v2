package com.demo.resttutorial.layer4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.resttutorial.layer2.Burger;
import com.demo.resttutorial.layer3.BurgerRepository;

@Service

public class BurgerServiceImpl implements BurgerService {

    // autowiring burger repository
    @Autowired
    private BurgerRepository burgerRepo;

    @Override
    public void addBurger(Burger burger) {
        Optional<Burger> opt = burgerRepo.findById(burger.getBurgerId());

        // if burger is already present
        if (opt.isPresent()) {
            throw new RuntimeException("Burger already present with id: " + burger.getBurgerId());
        } else {
            burgerRepo.save(burger);
        }
    }

    @Override
    public Burger findBurger(int burgerId) {
        Optional<Burger> opt = burgerRepo.findById(burgerId);

        if (opt.isPresent()) {
            Burger burger = opt.get();
            return burger;
        } else {
            throw new RuntimeException("Burger not found with id: " + burgerId);
        }
    }

    @Override
    public List<Burger> findAllBurgers() {
        List<Burger> burgerList = (List<Burger>) burgerRepo.findAll();

        // check if list is empty
        if (burgerList.size() == 0) {
            throw new RuntimeException("No burger found!");
        } else {
            return burgerList;
        }
    }

    @Override
    public void updateBurger(Burger burger) {
        Optional<Burger> opt = burgerRepo.findById(burger.getBurgerId());

        if (opt.isPresent()) {
            burgerRepo.save(burger);
        } else {
            throw new RuntimeException("Burger not found with id: " + burger.getBurgerId());
        }
    }

    @Override
    public void deleteBurger(int burgerId) {
        Optional<Burger> opt = burgerRepo.findById(burgerId);

        if (opt.isPresent()) {
            burgerRepo.deleteById(burgerId);
        } else {
            throw new RuntimeException("Burger not found with id: " + burgerId);
        }
    }

}

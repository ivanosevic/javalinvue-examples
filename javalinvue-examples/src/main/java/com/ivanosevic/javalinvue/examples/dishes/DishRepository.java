package com.ivanosevic.javalinvue.examples.dishes;

import java.util.List;
import java.util.Optional;

public interface DishRepository {
    List<Dish> findAll();

    Optional<Dish> findById(String id);

    void create(Dish dish);

    void update(Dish dish);

    void delete(Dish dish);
}

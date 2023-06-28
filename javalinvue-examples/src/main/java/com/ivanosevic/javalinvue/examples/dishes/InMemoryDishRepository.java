package com.ivanosevic.javalinvue.examples.dishes;

import net.datafaker.Faker;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryDishRepository implements DishRepository {

    private final List<Dish> dishes;

    public InMemoryDishRepository() {
        this.dishes = new CopyOnWriteArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 30; i++) {
            String name = faker.food().dish();
            BigDecimal price = BigDecimal.valueOf(faker.number().randomDouble(2, 50, 150));
            var newDish = new Dish("", name, price);
            create(newDish);
        }
    }


    @Override
    public List<Dish> findAll() {
        return dishes;
    }

    @Override
    public Optional<Dish> findById(String id) {
        return dishes.stream().filter(dish -> dish.id().equals(id)).findFirst();
    }

    @Override
    public void create(Dish dish) {
        String id = UUID.randomUUID().toString();
        var newDish = new Dish(id, dish.name(), dish.price());
        dishes.add(newDish);
    }

    @Override
    public void update(Dish dish) {
        dishes.stream().filter(d -> d.id().equals(dish.id())).findFirst().ifPresent(foundDish -> {
            var updatedDish = new Dish(foundDish.id(), dish.name(), dish.price());
            dishes.remove(foundDish);
            dishes.add(updatedDish);
        });
    }

    @Override
    public void delete(Dish dish) {
        dishes.remove(dish);
    }
}

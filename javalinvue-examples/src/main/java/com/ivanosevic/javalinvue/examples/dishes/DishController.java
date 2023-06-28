package com.ivanosevic.javalinvue.examples.dishes;

import com.ivanosevic.javalinvue.examples.Controller;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class DishController implements Controller {

    private final DishRepository dishRepository;

    public DishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public void findDishById(Context ctx) {
        var dishId = ctx.pathParam("id");
        dishRepository.findById(dishId).ifPresentOrElse(dish -> {
            ctx.json(dish);
        }, () -> {
            ctx.status(HttpStatus.NOT_FOUND);
        });
    }

    public void addNewDish(Context ctx) {
        var dish = ctx.bodyAsClass(Dish.class);
        dishRepository.create(dish);
        ctx.status(HttpStatus.CREATED);
    }

    public void findAllDishes(Context ctx) {
        var dishes = dishRepository.findAll();
        if (dishes.isEmpty()) {
            ctx.status(HttpStatus.NO_CONTENT);
            return;
        }
        ctx.json(dishes);
    }

    @Override
    public void routes(Javalin app) {
        app.get("/api/dishes", this::findAllDishes);
        app.post("/api/dishes", this::addNewDish);
        app.get("/api/dishes/{id}", this::findDishById);
    }
}

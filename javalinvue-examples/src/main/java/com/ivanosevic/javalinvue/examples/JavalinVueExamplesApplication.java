package com.ivanosevic.javalinvue.examples;

import com.ivanosevic.javalinvue.examples.dishes.Dish;
import com.ivanosevic.javalinvue.examples.dishes.DishRepository;
import com.ivanosevic.javalinvue.examples.dishes.InMemoryDishRepository;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;

public class JavalinVueExamplesApplication {
    public static void main(String[] args) {
        DishRepository dishRepository = new InMemoryDishRepository();

        var app = Javalin.create();


        app.get("/api/dishes", ctx -> {
            var dishes = dishRepository.findAll();
            if (dishes.isEmpty()) {
                ctx.status(HttpStatus.NO_CONTENT);
                return;
            }
            ctx.json(dishes);
        });

        app.post("/api/dishes", ctx -> {
            var dish = ctx.bodyAsClass(Dish.class);
            dishRepository.create(dish);
            ctx.status(HttpStatus.CREATED);
        });

        app.get("/api/dishes/{id}", ctx -> {
            var dishId = ctx.pathParam("id");
            dishRepository.findById(dishId).ifPresentOrElse(dish -> {
                ctx.json(dish);
            }, () -> {
                ctx.status(HttpStatus.NOT_FOUND);
            });
        });

        app.start(7000);
    }
}
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
                // Status helps to define the status of a call.
                ctx.status(HttpStatus.NO_CONTENT);
                // End of the function. Endpoint will stop here.
                return;
            }
            ctx.json(dishes);
        });

        app.post("/api/dishes", ctx -> {
            // We are telling Javalin that the body of the request
            // will be a Dish class, and we want it as a JSON.
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
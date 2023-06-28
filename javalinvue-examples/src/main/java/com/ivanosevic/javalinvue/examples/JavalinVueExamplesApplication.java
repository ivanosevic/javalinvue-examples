package com.ivanosevic.javalinvue.examples;

import com.ivanosevic.javalinvue.examples.dishes.DishController;
import com.ivanosevic.javalinvue.examples.dishes.DishRepository;
import com.ivanosevic.javalinvue.examples.dishes.InMemoryDishRepository;
import io.javalin.Javalin;

public class JavalinVueExamplesApplication {
    public static void main(String[] args) {
        DishRepository dishRepository = new InMemoryDishRepository();

        var app = Javalin.create();
        var dishController = new DishController(dishRepository);
        dishController.routes(app);

        app.start(7000);
    }
}
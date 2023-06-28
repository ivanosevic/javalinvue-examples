package com.ivanosevic.javalinvue.examples;

import com.ivanosevic.javalinvue.examples.dishes.DishController;
import com.ivanosevic.javalinvue.examples.dishes.DishRepository;
import com.ivanosevic.javalinvue.examples.dishes.InMemoryDishRepository;
import io.javalin.Javalin;
import io.javalin.vue.VueComponent;

public class JavalinVueExamplesApplication {
    public static void main(String[] args) {
        DishRepository dishRepository = new InMemoryDishRepository();
        var dishController = new DishController(dishRepository);

        var app = Javalin.create(configuration -> {
            // Enable WebJars
            configuration.staticFiles.enableWebjars();

            // If we want to use Vue3, we need to tell JavalinVue what's the
            // vueApplicationName
            configuration.vue.vueAppName = "app";

            // Very important if you want to debug your endpoints
            configuration.plugins.enableDevLogging();

            // Shows you all application routes
            configuration.plugins.enableRouteOverview("/api/v1/routes");
        });

        dishController.routes(app);


        app.get("/counter", new VueComponent("counter"));
        app.get("/", new VueComponent("index"));

        app.start(7070);
    }
}
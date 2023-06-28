package com.ivanosevic.javalinvue.examples;

import com.ivanosevic.javalinvue.examples.countries.CountryController;
import com.ivanosevic.javalinvue.examples.countries.InMemoryCountryRepository;
import com.ivanosevic.javalinvue.examples.dishes.DashboardController;
import com.ivanosevic.javalinvue.examples.dishes.DishController;
import com.ivanosevic.javalinvue.examples.dishes.InMemoryDishRepository;
import com.ivanosevic.javalinvue.examples.suppliers.InMemorySupplierRepository;
import com.ivanosevic.javalinvue.examples.suppliers.SuppliersController;
import io.javalin.Javalin;

public class JavalinVueExamplesApplication {
    public static void main(String[] args) {
        var dishRepository = new InMemoryDishRepository();
        var supplierRepository = new InMemorySupplierRepository();
        var countryRepository = new InMemoryCountryRepository();

        var countryController = new CountryController(countryRepository);
        var supplierController = new SuppliersController(supplierRepository);
        var dishController = new DishController(dishRepository);
        var counterController = new CounterController();
        var dashboardController = new DashboardController();
        var serverSideExampleController = new ServerSideExampleController();

        var app = Javalin.create(configuration -> {
            // Enable WebJars
            configuration.staticFiles.enableWebjars();

            // If we want to use Vue3, we need to tell JavalinVue what's the
            // vueApplicationName
            configuration.vue.vueAppName = "app";

            // Very important if you want to debug your endpoints
            configuration.plugins.enableDevLogging();

            // Shows you all application routes
            configuration.plugins.enableRouteOverview("/api/routes");
        });

        dashboardController.routes(app);
        counterController.routes(app);
        dishController.routes(app);
        serverSideExampleController.routes(app);
        supplierController.routes(app);
        countryController.routes(app);

        app.start(7000);
    }
}
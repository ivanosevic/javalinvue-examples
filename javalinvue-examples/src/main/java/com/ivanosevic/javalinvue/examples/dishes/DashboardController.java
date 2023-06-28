package com.ivanosevic.javalinvue.examples.dishes;

import com.ivanosevic.javalinvue.examples.Controller;
import io.javalin.Javalin;
import io.javalin.vue.VueComponent;

public class DashboardController implements Controller {

    @Override
    public void routes(Javalin app) {
        app.get("/", context -> context.redirect("/dashboard"));
        app.get("/dashboard", new VueComponent("dashboard"));
    }
}

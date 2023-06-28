package com.ivanosevic.javalinvue.examples;

import io.javalin.Javalin;
import io.javalin.vue.VueComponent;

public class CounterController implements Controller {
    @Override
    public void routes(Javalin app) {
        app.get("/counter", new VueComponent("counter"));
    }
}

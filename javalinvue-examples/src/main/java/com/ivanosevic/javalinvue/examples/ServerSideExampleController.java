package com.ivanosevic.javalinvue.examples;

import io.javalin.Javalin;
import io.javalin.vue.VueComponent;

import java.util.Map;

public class ServerSideExampleController implements Controller {

    @Override
    public void routes(Javalin app) {
        app.get("/server-side-example", new VueComponent("server-side-example", Map.of("message", "Hello from the server.")));
    }
}

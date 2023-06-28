package com.ivanosevic.javalinvue.examples;

import io.javalin.Javalin;

public interface Controller {
    void routes(Javalin app);
}

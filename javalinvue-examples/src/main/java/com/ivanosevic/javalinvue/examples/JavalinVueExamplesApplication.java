package com.ivanosevic.javalinvue.examples;

import io.javalin.Javalin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class JavalinVueExamplesApplication {
    public static void main(String[] args) {
        // Creating the server instance
        var app = Javalin.create();

        /*
         * Registering our endpoint to the Javalin Server Instance
         * In this case, we have a GET method, with the /hello-world path.
         */
        app.get("/hello-world", ctx -> {
            var currentDateAsString = LocalDate.now().format(DateTimeFormatter.ISO_DATE);

            // Message we want to send over our endpoint.
            var message = Map.of("message", "Hello World!", "date", currentDateAsString);

            // This will convert the object to JSON (Jackson is the default converter),
            // add all the media tags required and send it as the body of the response.
            ctx.json(message);
        });

        // Starting the web server at the specified port.
        app.start(7000);
    }
}
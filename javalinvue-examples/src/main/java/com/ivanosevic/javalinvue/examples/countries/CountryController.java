package com.ivanosevic.javalinvue.examples.countries;

import com.ivanosevic.javalinvue.examples.Controller;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class CountryController implements Controller {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void findAllCountries(Context ctx) {
        var countries = countryRepository.findAll();
        ctx.status(HttpStatus.OK).json(countries);
    }

    public void createCountry(Context ctx) {
        var countryForm = ctx.bodyAsClass(Country.class);
        countryRepository.create(countryForm.name(), countryForm.isoCode2());
        ctx.status(HttpStatus.CREATED);
    }

    @Override
    public void routes(Javalin app) {
        app.get("/api/v1/countries", this::findAllCountries);
        app.post("/api/v1/countries", this::createCountry);
    }
}

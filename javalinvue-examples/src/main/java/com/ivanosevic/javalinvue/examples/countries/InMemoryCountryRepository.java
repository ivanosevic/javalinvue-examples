package com.ivanosevic.javalinvue.examples.countries;


import net.datafaker.Faker;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryCountryRepository implements CountryRepository {

    private final List<Country> countries;

    public InMemoryCountryRepository() {
        this.countries = new CopyOnWriteArrayList<>();
        var faker = new Faker();
        for (int i = 0; i < 10; i++) {
            String country = faker.address().country();
            String countryCode = faker.address().countryCode();
            create(country, countryCode);
        }
    }

    @Override
    public List<Country> findAll() {
        return this.countries;
    }

    @Override
    public Optional<Country> findById(String id) {
        return countries.stream().filter(country -> country.id().equals(id)).findFirst();
    }

    @Override
    public Country create(String name, String isoCode2) {
        String id = UUID.randomUUID().toString();
        var country = new Country(id, name, isoCode2);
        countries.add(country);
        return country;
    }
}

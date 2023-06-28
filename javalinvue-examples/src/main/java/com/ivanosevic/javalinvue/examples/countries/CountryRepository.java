package com.ivanosevic.javalinvue.examples.countries;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {
    List<Country> findAll();

    Optional<Country> findById(String id);

    Country create(String name, String isoCode2);
}

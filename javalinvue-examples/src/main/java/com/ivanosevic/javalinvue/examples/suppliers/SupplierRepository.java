package com.ivanosevic.javalinvue.examples.suppliers;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository {
    List<Supplier> findAll();

    Optional<Supplier> findById(String id);

    Supplier create(Supplier supplier);

    Supplier update(Supplier supplier);

    void delete(Supplier supplier);
}

package com.ivanosevic.javalinvue.examples.suppliers;

import net.datafaker.Faker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemorySupplierRepository implements SupplierRepository {

    private final List<Supplier> suppliers;

    public InMemorySupplierRepository() {
        this.suppliers = new CopyOnWriteArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            String name = faker.name().firstName();
            String lastname = faker.name().lastName();
            String email = faker.internet().emailAddress();
            int deliveryTimeInDays = faker.random().nextInt(1, 25);
            String country = faker.address().country();
            var supplier = new Supplier(name, lastname, email, country, deliveryTimeInDays);
            create(supplier);
        }
    }

    @Override
    public List<Supplier> findAll() {
        return this.suppliers;
    }

    @Override
    public Optional<Supplier> findById(String id) {
        return this.suppliers.stream().filter(supplier -> supplier.getId().equals(id)).findFirst();
    }

    @Override
    public Supplier create(Supplier supplier) {
        var id = UUID.randomUUID().toString();
        supplier.setId(id);
        suppliers.add(supplier);
        return supplier;
    }

    @Override
    public Supplier update(Supplier supplier) {
        var supplierToUpdate = this.suppliers.stream().filter(s -> s.getId().equals(supplier.getId())).findFirst().orElseThrow(SupplierNotFoundException::new);
        supplierToUpdate.setCountry(supplier.getCountry());
        supplierToUpdate.setName(supplier.getName());
        supplierToUpdate.setLastname(supplier.getLastname());
        supplierToUpdate.setLastUpdatedAt(LocalDateTime.now());
        supplierToUpdate.setDeliveryTimeInDays(supplier.getDeliveryTimeInDays());
        supplierToUpdate.setEmail(supplier.getEmail());
        return supplierToUpdate;
    }

    @Override
    public void delete(Supplier supplier) {
        var supplierToUpdate = this.suppliers.stream().filter(s -> s.getId().equals(supplier.getId())).findFirst().orElseThrow(SupplierNotFoundException::new);
        suppliers.remove(supplier);
    }
}

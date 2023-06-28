package com.ivanosevic.javalinvue.examples.suppliers;

import com.ivanosevic.javalinvue.examples.Controller;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import io.javalin.vue.VueComponent;

import java.util.Map;

public class SuppliersController implements Controller {

    private final SupplierRepository supplierRepository;

    public SuppliersController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void findAllSuppliers(Context ctx) {
        var suppliers = supplierRepository.findAll();
        if (suppliers.isEmpty()) {
            ctx.status(HttpStatus.NO_CONTENT).json(suppliers);
            return;
        }
        ctx.status(HttpStatus.OK).json(suppliers);
    }

    public void findSupplierById(Context ctx) {
        var supplierId = ctx.pathParam("supplierId");
        var supplier = supplierRepository.findById(supplierId).orElseThrow(SupplierNotFoundException::new);
        ctx.json(supplier);
    }

    public void handleSupplierNotFoundException(SupplierNotFoundException ex, Context ctx) {
        var error = Map.of("message", ex.getMessage());
        ctx.status(404).json(error);
    }

    @Override
    public void routes(Javalin app) {
        app.get("/suppliers", new VueComponent("suppliers"));
        app.get("/suppliers/{supplierId}", new VueComponent("supplier-details"));
        app.get("/api/v1/suppliers", this::findAllSuppliers);
        app.get("/api/v1/suppliers/{supplierId}", this::findSupplierById);
        app.exception(SupplierNotFoundException.class, this::handleSupplierNotFoundException);
    }
}

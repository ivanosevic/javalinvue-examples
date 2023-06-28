package com.ivanosevic.javalinvue.examples.suppliers;

import com.ivanosevic.javalinvue.examples.EntityNotFoundException;

public class SupplierNotFoundException extends EntityNotFoundException {

    public SupplierNotFoundException() {
        super("The supplier could not be found.");
    }
}

package vrs.models.enums.vehiclecategories;

import vrs.models.interfaces.VehicleCategory;

public enum CarCategory implements VehicleCategory {
    CONVERTIBLE,
    HATCHBACK,
    SEDAN,
    SUV;

    @Override
    public String getCategoryName() {
        return this.name();
    }
}

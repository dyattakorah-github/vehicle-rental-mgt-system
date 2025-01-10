package vrs.models.enums.vehicle.othercategories;

import vrs.models.interfaces.OtherCategory;

public enum FuelType implements OtherCategory {
    DIESEL,
    ELECTRIC,
    HYBRID,
    PETROL;

    @Override
    public String getCategoryName() {
        return this.name();
    }
}

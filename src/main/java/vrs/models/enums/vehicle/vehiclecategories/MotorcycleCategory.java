package vrs.models.enums.vehicle.vehiclecategories;

import vrs.models.interfaces.VehicleCategory;

public enum MotorcycleCategory implements VehicleCategory{
    CRUISER,
    DUAL_SPORT,
    STANDARD,
    SPORTS,
    TOURING;

    @Override
    public String getCategoryName() {
        return this.name();
    }
}

package vrs.models.enums.vehiclecategories;

import vrs.models.interfaces.VehicleCategory;

public enum TruckCategory implements VehicleCategory {
    BOX_TRUCK,
    DUMP_TRUCK,
    PICKUP,
    SEMI_TRUCK,
    TOW_TRUCK;

    @Override
    public String getCategoryName() {
        return this.name();
    }
}

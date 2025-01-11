package vrs.business;

import vrs.models.enums.vehicle.othercategories.FuelType;
import vrs.models.enums.vehicle.vehiclecategories.TruckCategory;
import vrs.models.vehicle.Vehicle;

public class TruckRentalCostCalculator extends RentalCostCalculator {

    @Override
    protected double getCategoryFactor(Vehicle vehicle) {
        TruckCategory category = (TruckCategory) vehicle.getVehicleCategory();
        switch (category) {
            case BOX_TRUCK: return 1.6;   // Box trucks typically cost more
            case DUMP_TRUCK: return 1.8;  // Dump trucks are specialized and usually more expensive
            case PICKUP: return 1.2;      // Pickup trucks are somewhat cheaper than larger trucks
            case SEMI_TRUCK: return 2.0;  // Semi trucks are high-cost vehicles
            case TOW_TRUCK: return 1.7;   // Tow trucks are expensive due to their specialty
            default: return 1.0;          // Default factor if the category is unknown
        }
    }

    @Override
    protected double getFuelFactor(Vehicle vehicle) {
        FuelType fuelType = vehicle.getFuelType();
        switch (fuelType) {
            case ELECTRIC: return 1.0;   // Electric trucks are rare but might cost the same as petrol
            case PETROL: return 1.0;     // Standard petrol trucks
            case HYBRID: return 1.3;     // Hybrid trucks might be slightly more expensive
            case DIESEL: return 1.2;     // Diesel trucks tend to be slightly more expensive
            default: return 1.0;
        }
    }

    @Override
    protected double getBrandFactor(Vehicle vehicle) {
        // Brand-specific factors can be applied here (e.g., more premium brands may cost more)
        switch (vehicle.getBrand().getBrandName()) {
            case "Ford": return 1.1;   // Ford trucks may have a standard rental cost
            case "Chevrolet": return 1.2;  // Chevrolet trucks may cost slightly more
            case "Peterbilt": return 1.4;  // Peterbilt semi trucks are more expensive
            default: return 1.0;          // Default factor
        }
    }

    @Override
    protected double calculateCostForVehicle(Vehicle vehicle, int days, double baseCost, double ageFactor, double categoryFactor, double fuelFactor, double brandFactor) {
        return baseCost * days * (1 + ageFactor) * categoryFactor * fuelFactor * brandFactor;
    }
}

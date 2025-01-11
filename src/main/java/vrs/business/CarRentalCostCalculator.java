package vrs.business;

import vrs.models.enums.vehicle.othercategories.FuelType;
import vrs.models.enums.vehicle.vehiclecategories.CarCategory;
import vrs.models.vehicle.Vehicle;


public class CarRentalCostCalculator extends RentalCostCalculator {

    @Override
    protected double getCategoryFactor(Vehicle vehicle) {

        CarCategory category = (CarCategory) vehicle.getVehicleCategory();
        switch (category) {
            case CONVERTIBLE: return 1.5; // More expensive
            case HATCHBACK: return 1.0;   // Base cost
            case SEDAN: return 1.2;       // Slightly higher than hatchback
            case SUV: return 1.3;         // Higher base cost
            default: return 1.0;
        }
    }

    @Override
    protected double getFuelFactor(Vehicle vehicle) {
        // Example logic for fuel type pricing
        FuelType fuelType = vehicle.getFuelType();
        switch (fuelType) {
            case ELECTRIC: return 0.8;    // Electric cars might be cheaper
            case PETROL: return 1.0;      // Standard petrol vehicles
            case HYBRID: return 1.2;      // Hybrid cars might cost more
            case DIESEL: return 1.1;      // Diesel cars might be slightly more expensive
            default: return 1.0;
        }
    }

    @Override
    protected double getBrandFactor(Vehicle vehicle) {
        switch (vehicle.getBrand().getBrandName()) {
            case "Mercedes": return 1.3;  // Premium brand, higher rental cost
            case "Toyota": return 1.0;    // Standard brand, no change
            case "BMW": return 1.2;       // Luxury brand, slightly higher
            case "Ford": return 0.9;      // Lower cost for this brand
            default: return 1.0;          // Default factor if brand is not listed
        }
    }

    @Override
    protected double calculateCostForVehicle(Vehicle vehicle, int days, double baseCost, double ageFactor, double categoryFactor, double fuelFactor, double brandFactor) {
        return baseCost * days * (1 + ageFactor) * categoryFactor * fuelFactor;
    }

}

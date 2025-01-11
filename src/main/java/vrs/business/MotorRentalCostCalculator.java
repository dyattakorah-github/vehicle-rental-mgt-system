package vrs.business;

import vrs.models.enums.vehicle.othercategories.FuelType;
import vrs.models.enums.vehicle.vehiclecategories.MotorcycleCategory;
import vrs.models.vehicle.Vehicle;

public class MotorRentalCostCalculator extends RentalCostCalculator {

    @Override
    protected double getCategoryFactor(Vehicle vehicle) {
        MotorcycleCategory category = (MotorcycleCategory) vehicle.getVehicleCategory();
        switch (category) {
            case CRUISER: return 1.2;  // Cruiser motorcycles
            case DUAL_SPORT: return 1.3; // Dual-sport motorcycles
            case STANDARD: return 1.0;  // Standard motorcycles
            case SPORTS: return 1.5;   // Sports motorcycles
            case TOURING: return 1.4;  // Touring motorcycles
            default: return 1.0;       // Default factor
        }
    }

    @Override
    protected double getFuelFactor(Vehicle vehicle) {
        FuelType fuelType = vehicle.getFuelType();
        switch (fuelType) {
            case ELECTRIC: return 0.9;    // Electric motorcycles might be cheaper
            case PETROL: return 1.0;      // Standard petrol motorcycles
            case HYBRID: return 1.1;      // Hybrid motorcycles might cost more
            case DIESEL: return 1.2;      // Diesel motorcycles might be slightly more expensive
            default: return 1.0;
        }
    }

    @Override
    protected double getBrandFactor(Vehicle vehicle) {
        // Apply different factors based on the vehicle brand (example)
        switch (vehicle.getBrand().getBrandName()) {
            case "Harley-Davidson": return 1.4;  // Premium brand
            case "Honda": return 1.1;    // Standard brand
            case "Yamaha": return 1.2;   // Slightly higher cost
            default: return 1.0;          // Default factor
        }
    }

    @Override
    protected double calculateCostForVehicle(Vehicle vehicle, int days, double baseCost, double ageFactor, double categoryFactor, double fuelFactor, double brandFactor) {
        return baseCost * days * (1 + ageFactor) * categoryFactor * fuelFactor * brandFactor;
    }
}

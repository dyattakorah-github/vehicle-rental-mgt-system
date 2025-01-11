package vrs.services;

import vrs.models.vehicle.Vehicle;

public abstract class RentalCostCalculator {

    public double calculateRentalCost(Vehicle vehicle, int days) {
        double baseCost = vehicle.getBaseRentalRate();
        double ageFactor = calculateAgeFactor(vehicle);
        double categoryFactor = getCategoryFactor(vehicle);
        double fuelFactor = getFuelFactor(vehicle);

        return calculateCostForVehicle(vehicle, days, baseCost, ageFactor, categoryFactor, fuelFactor);
    }

    protected double calculateAgeFactor(Vehicle vehicle) {
        int age = vehicle.calculateAge();
        return 0.05 * age;
    }

    protected abstract double getCategoryFactor(Vehicle vehicle);
    protected abstract double getFuelFactor(Vehicle vehicle);

    protected abstract double calculateCostForVehicle(Vehicle vehicle, int days, double baseCost, double ageFactor, double categoryFactor, double fuelFactor);

}

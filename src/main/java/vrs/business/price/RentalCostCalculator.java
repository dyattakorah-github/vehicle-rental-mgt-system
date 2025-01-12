package vrs.business;

import vrs.models.Bookings;
import vrs.models.vehicle.Vehicle;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public abstract class RentalCostCalculator {

    // Method to calculate rental cost based on vehicle and booking details
    public double calculateRentalCost(Vehicle vehicle, Bookings booking) {
        // Base cost calculation
        double baseCost = vehicle.getBaseRentalRate();

        // Access the rental  start date from the booking object
        LocalDateTime rentalStartDate = booking.getRentalDate();

        // Calculate the rental duration (in days)
        long daysRented = booking.calculateRentalDuration();

        // Calculate factors based on vehicle properties
        double ageFactor = calculateAgeFactor(vehicle);
        double categoryFactor = getCategoryFactor(vehicle);
        double fuelFactor = getFuelFactor(vehicle);
        double brandFactor = getBrandFactor(vehicle);

        // Calculate dynamic pricing based on the rental start date
        double dynamicPricingFactor =  calculateDynamicPricingFactor(rentalStartDate);

        // Return the final calculated rent cost
        return calculateCostForVehicle(vehicle, daysRented, baseCost, ageFactor, categoryFactor, fuelFactor, brandFactor, dynamicPricingFactor);
    }

    // Abstract method that subclasses must implement to calculate final rental cost
    protected abstract double calculateCostForVehicle(Vehicle vehicle, long daysRented, double baseCost,
                                                      double ageFactor, double categoryFactor,
                                                      double fuelFactor, double brandFactor, double dynamicPricingFactor);

    // Helper method to calculate dynamic pricing based on the rental start date
    private double calculateDynamicPricingFactor(LocalDateTime rentalStartDate) {
        double dynamicFactor = 1.0;

        // Check if the rental starts on a weekend (Saturday or Sunday)
        if (rentalStartDate.getDayOfWeek() == DayOfWeek.SATURDAY || rentalStartDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            dynamicFactor += 0.2; // Add 20% on weekends
        }

        // Check if the rental is during peak season (e.g., December, June, July, August)
         int month = rentalStartDate.getMonthValue();
        if (month == 12 || month == 6 || month == 7 || month == 8) {
            dynamicFactor += 0.5; // Add 50% during peak months
        }

        return dynamicFactor;
    }

    // Method for calculating age factor
    protected double calculateAgeFactor(Vehicle vehicle) {
        int age = vehicle.calculateAge();
        return 0.05 * age;
    }

    protected abstract double getCategoryFactor(Vehicle vehicle);
    protected abstract double getFuelFactor(Vehicle vehicle);
    protected abstract double getBrandFactor(Vehicle vehicle);


}

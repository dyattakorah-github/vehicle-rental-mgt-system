package vrs.models.vehicle;

import vrs.models.enums.FuelType;
import vrs.models.enums.EngineType;
import vrs.models.interfaces.VehicleCategory;
import vrs.models.others.Brand;

import java.util.Objects;

/**
 * The {@code Motorcycle} represents a motorcycle within the vehicle rental system.
 * It extends the {@code Vehicle} and includes specific attributes
 * such as engineType, mileage
 * This class also includes methods for calculating rental cost, checking availability
 * and determining if the motorcycle is due for maintenance
 */
public class Motorcycle extends Vehicle {
    private EngineType engineType;
    private double mileage;

/**
 * Constructs a new {@code Motorcycle} object with the specified parameters.
 * Validates attributes like engine type, seat capacity, and mileage.
 *
 * @param vehicleId the unique identifier for the vehicle
 * @param licensePlate the vehicle's license plate
 * @param model the vehicle model
 * @param brand the brand of the vehicle
 * @param fuelType the fuel type of the vehicle (e.g., Petrol, Diesel)
 * @param vehicleCategory the category of the vehicle (e.g., Cruiser, Sportbike)
 * @param baseRentalRate the base rental rate per day
 * @param isAvailable the availability status of the vehicle
 * @param engineType the engine type (e.g., Single-cylinder, V-twin)
 * @param mileage the mileage of the motorcycle (between 12 and 42 km/l)
 * @throws IllegalArgumentException if any of the provided values are invalid
 */
public Motorcycle(String vehicleId, String licensePlate, String model, Brand brand,
                      FuelType fuelType, VehicleCategory vehicleCategory, double baseRentalRate,
                      boolean isAvailable, EngineType engineType, double mileage) {
        super(vehicleId, licensePlate, model, brand, fuelType, vehicleCategory, baseRentalRate, isAvailable);
        if (engineType == null) {
            throw new IllegalArgumentException("Engine type cannot be empty");
        }
        if (mileage < 12.7 || mileage > 42.0) {
            throw new IllegalArgumentException("Mileage must be between 12.7 and 42 km/l (kilometres per litre)");
        }
        this.engineType = engineType;
        this.mileage = mileage;
    }

    /**
     * Returns the engine type of the motorcycle.
     *
     * @return the engine type (e.g., Single-cylinder, V-twin)
     */
    public EngineType getEngineType() {
        return engineType;
    }

    /**
     * Returns the mileage of the motorcycle in kilometers per litre.
     *
     * @return the mileage (between 12.7 and 42 km/l)
     */
    public double getMileage() {
        return mileage;
    }

    /**
     * Sets the engine type of the motorcycle.
     *
     * @param engineType the new engine type
     * @throws IllegalArgumentException if the engine type is invalid
     */
    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    /**
     * Sets the mileage of the motorcycle.
     * Validates that the mileage is between 12.7 and 42 kilometers per litre.
     *
     * @param mileage the new mileage in kilometers per litre
     * @throws IllegalArgumentException if the mileage is invalid
     */
    public void setMileage(double mileage) {
        if (mileage < 12.7 || mileage > 42) {
            throw new IllegalArgumentException("Mileage must be between 12.7 and 42 km/l (kilometres per litre)");
        }
        this.mileage = mileage;
    }

    /**
     * Calculates the rental cost for the motorcycle based on the number of days rented.
     *
     * @param days the number of days the motorcycle is rented
     * @return the total rental cost for the specified number of days
     * @throws IllegalArgumentException if the number of rental days is not positive
     */
    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Rental days must be positive");
        }
        return days * getBaseRentalRate();
        // TODO: Implement dynamic pricing for motorcycles (e.g., discounts, seasonal rates)
    }

    /**
     * Checks if the motorcycle is available for rental.
     *
     * @return {@code true} if the motorcycle is available, {@code false} otherwise
     */
    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    /**
     * Checks if the motorcycle is available for rental on the given date range.
     *
     * @param startDate the start date of the rental period
     * @param endDate the end date of the rental period
     * @return {@code true} if the motorcycle is available, {@code false} otherwise
     */
    @Override
    public boolean isAvailableOnDate(String startDate, String endDate) {
        // TODO: Implement date-based availability check using booking system
        return true; // Placeholder for future logic
    }

    /**
     * Checks if the motorcycle is due for maintenance.
     *
     * @return {@code true} if the motorcycle is due for maintenance, {@code false} otherwise
     */
    @Override
    public boolean isDueForMaintenance() {
        // TODO: Implement maintenance check logic based on mileage or last service date
        return false; // Placeholder for future logic
    }

    /**
     * Returns a string representation of the {@code Motorcycle} object.
     *
     * @return a string representing the motorcycle's attributes
     */
    @Override
    public String toString() {
        return super.toString() +
                "engineType=" + engineType +
                ", mileage=" + mileage +
                '}';
    }


    /**
     * Checks if two {@code Motorcycle} objects are equal.
     *
     * @param o the object to compare with
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Motorcycle that = (Motorcycle) o;
        return Double.compare(mileage, that.mileage) == 0 && engineType == that.engineType;
    }

    /**
     * Returns the hash code for the {@code Motorcycle} object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineType, mileage);
    }
}

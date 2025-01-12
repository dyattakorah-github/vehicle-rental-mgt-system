package vrs.models.vehicle;

import vrs.models.enums.vehicle.othercategories.FuelType;
import vrs.models.enums.vehicle.vehiclecategories.TruckCategory;
import vrs.models.others.Brand;

import java.util.Objects;

/**
 * The {@code Truck} class represents a truck within the vehicle rental system.
 * It extends the {@code Vehicle} class and includes specific attributes
 * such as cargo capacity, cargo bed size, and axle count.
 *
 * This class also includes methods for calculating rental cost, checking availability,
 * and determining if the truck is due for maintenance.
 */
public class Truck extends Vehicle {
    private double cargoCapacity;
    private double cargoBedSize;
    private int axleCount;

    /**
     * Constructs a new {@code Truck} object with the specified parameters.
     * Validates attributes like cargo capacity, cargo bed size, and axle count.
     *
     * @param vehicleId the unique identifier for the vehicle
     * @param licensePlate the vehicle's license plate
     * @param model the vehicle model
     * @param brand the brand of the vehicle
     * @param fuelType the fuel type of the vehicle (e.g., Petrol, Diesel)
     * @param vehicleCategory the category of the vehicle (e.g., Pickup, Flatbed)
     * @param baseRentalRate the base rental rate per day
     * @param isAvailable the availability status of the vehicle
     * @param cargoCapacity the cargo capacity of the truck (between 550 and 3200 kg)
     * @param cargoBedSize the cargo bed size in litres (between 700 and 4000 litres)
     * @param axleCount the number of axles (between 2 and 10)
     * @throws IllegalArgumentException if any of the provided values are invalid
     */
    public Truck(String vehicleId, String licensePlate, String model, Brand brand, FuelType fuelType, TruckCategory vehicleCategory,
                 double baseRentalRate, boolean isAvailable, double cargoCapacity, double cargoBedSize, int axleCount) {
        super(vehicleId, licensePlate, model, brand, fuelType, vehicleCategory, baseRentalRate, isAvailable);

        if (cargoCapacity < 550 || cargoCapacity > 3200) {
            throw new IllegalArgumentException("Cargo capacity must be between 550 and 3200 kilograms");
        }
        if (cargoBedSize < 700 || cargoBedSize > 4000) {
            throw new IllegalArgumentException("Cargo bed size must be between 700 and 4000 litres");
        }
        if (axleCount < 2 || axleCount > 10) {
            throw new IllegalArgumentException("Axle count must be between 2 and 10");
        }

        this.cargoCapacity = cargoCapacity;
        this.cargoBedSize = cargoBedSize;
        this.axleCount = axleCount;
    }

    /**
     * Returns the cargo capacity of the truck in kilograms.
     *
     * @return the cargo capacity (between 550 and 3200 kg)
     */
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * Returns the cargo bed size of the truck in litres.
     *
     * @return the cargo bed size (between 700 and 4000 litres)
     */
    public double getCargoBedSize() {
        return cargoBedSize;
    }

    /**
     * Returns the number of axles of the truck.
     *
     * @return the axle count (between 2 and 10)
     */
    public int getAxleCount() {
        return axleCount;
    }

    /**
     * Sets the cargo capacity of the truck.
     * Validates that the cargo capacity is between 550 and 3200 kilograms.
     *
     * @param cargoCapacity the new cargo capacity
     * @throws IllegalArgumentException if the cargo capacity is invalid
     */
    public void setCargoCapacity(double cargoCapacity) {
        if (cargoCapacity < 550 || cargoCapacity > 3200) {
            throw new IllegalArgumentException("Cargo capacity must be between 550 and 3200 kilograms");
        }
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * Sets the cargo bed size of the truck.
     * Validates that the cargo bed size is between 700 and 4000 litres.
     *
     * @param cargoBedSize the new cargo bed size
     * @throws IllegalArgumentException if the cargo bed size is invalid
     */
    public void setCargoBedSize(double cargoBedSize) {
        if (cargoBedSize < 700 || cargoBedSize > 4000) {
            throw new IllegalArgumentException("Cargo bed size must be between 700 and 4000 litres");
        }
        this.cargoBedSize = cargoBedSize;
    }

    /**
     * Sets the number of axles of the truck.
     * Validates that the axle count is between 2 and 10.
     *
     * @param axleCount the new axle count
     * @throws IllegalArgumentException if the axle count is invalid
     */
    public void setAxleCount(int axleCount) {
        if (axleCount < 2 || axleCount > 10) {
            throw new IllegalArgumentException("Axle count must be between 2 and 10");
        }
        this.axleCount = axleCount;
    }

    /**
     * Calculates the rental cost for the truck based on the number of days rented.
     *
     * @param days the number of days the truck is rented
     * @return the total rental cost for the specified number of days
     * @throws IllegalArgumentException if the number of rental days is not positive
     */
    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Rental days must be positive");
        }
        return days * getBaseRentalRate();
    }

    /**
     * Checks if the truck is available for rental.
     *
     * @return {@code true} if the truck is available, {@code false} otherwise
     */
    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    /**
     * Returns a string representation of the {@code Truck} object.
     *
     * @return a string representing the truck's attributes
     */
    @Override
    public String toString() {
        return super.toString() +
                ", cargoCapacity=" + cargoCapacity +
                ", axleCount=" + axleCount +
                ", cargoBedSize=" + cargoBedSize;
    }

    /**
     * Checks if two {@code Truck} objects are equal.
     *
     * @param o the object to compare with
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return Double.compare(truck.cargoCapacity, cargoCapacity) == 0 &&
                Double.compare(truck.cargoBedSize, cargoBedSize) == 0 &&
                axleCount == truck.axleCount;
    }

    /**
     * Returns the hash code for the {@code Truck} object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoCapacity, axleCount, cargoBedSize);
    }
}

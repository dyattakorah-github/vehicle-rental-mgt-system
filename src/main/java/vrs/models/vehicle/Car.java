package vrs.models.vehicle;

import vrs.models.enums.FuelType;
import vrs.models.interfaces.VehicleCategory;
import vrs.models.others.Brand;

import java.util.Objects;

/**
 * The {@code Car} class represents a car within the vehicle rental system.
 * It extends the {@code Vehicle} class and includes specific attributes
 * such as seating capacity, transmission type, trunk capacity, and mileage.
 *
 * This class also includes methods for calculating rental cost, checking availability,
 * and determining if the car is due for maintenance.
 *
 */
public class Car extends Vehicle {
    private int seatingCapacity;
    private String transmissionType;
    private double trunkCapacity;
    private double mileage;

    /**
     * Constructs a new {@code Car} object with the specified parameters.
     * Validates attributes like seating capacity, transmission type, trunk capacity, and mileage.
     *
     * @param vehicleId the unique identifier for the vehicle
     * @param licensePlate the vehicle's license plate
     * @param model the vehicle model
     * @param brand the brand of the vehicle
     * @param fuelType the fuel type of the vehicle (e.g., Petrol, Diesel)
     * @param vehicleCategory the category of the vehicle (e.g., Sedan, SUV)
     * @param baseRentalRate the base rental rate per day
     * @param isAvailable the availability status of the vehicle
     * @param seatingCapacity the seating capacity (between 2 and 9)
     * @param transmissionType the type of transmission (e.g., Manual, Automatic)
     * @param trunkCapacity the trunk capacity in litres (greater than 0 and less than or equal to 1000)
     * @param mileage the mileage of the vehicle (between 0 and 1,000,000 km)
     * @throws IllegalArgumentException if any of the provided values are invalid
     */
    public Car(String vehicleId, String licensePlate, String model, Brand brand,
               FuelType fuelType, VehicleCategory vehicleCategory, double baseRentalRate,
               boolean isAvailable, int seatingCapacity, String transmissionType, double trunkCapacity, double mileage) {
        super(vehicleId, licensePlate, model, brand, fuelType, vehicleCategory, baseRentalRate,
                isAvailable);
        if (seatingCapacity < 2 || seatingCapacity > 9) {
            throw new IllegalArgumentException("Seating capacity must be between 2 and 9");
        }
        if (transmissionType == null || transmissionType.isEmpty()) {
            throw new IllegalArgumentException("Transmission type cannot be empty");
        }
        if (trunkCapacity <= 340 || trunkCapacity > 1500) {
            throw new IllegalArgumentException("Trunk capacity must be between 3400 and 1,500 litres");
        }
        if (mileage < 0 || mileage > 1000000) {
            throw new IllegalArgumentException("Mileage must be between 0 and 1,000,000 km");
        }
        this.seatingCapacity = seatingCapacity;
        this.transmissionType = transmissionType;
        this.trunkCapacity = trunkCapacity;
        this.mileage = mileage;
    }

    /**
     * Returns the seating capacity of the car.
     *
     * @return the seating capacity (between 2 and 9)
     */
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    /**
     * Returns the transmission type of the car.
     *
     * @return the transmission type (e.g., Manual, Automatic)
     */
    public String getTransmissionType() {
        return transmissionType;
    }

    /**
     * Returns the trunk capacity of the car in litres.
     *
     * @return the trunk capacity (greater than 0 and less than or equal to 1000)
     */
    public double getTrunkCapacity() {
        return trunkCapacity;
    }

    /**
     * Returns the mileage of the car in kilometers.
     *
     * @return the mileage (between 0 and 1,000,000 km)
     */
    public double getMileage() {
        return mileage;
    }

    /**
     * Sets the seating capacity of the car.
     * Validates that the seating capacity is between 2 and 9.
     *
     * @param seatingCapacity the new seating capacity
     * @throws IllegalArgumentException if the seating capacity is not between 2 and 9
     */
    public void setSeatingCapacity(int seatingCapacity) {
        if (seatingCapacity < 2 || seatingCapacity > 9) {
            throw new IllegalArgumentException("Seating  capacity must be between 2 and 9");
        }
        this.seatingCapacity = seatingCapacity;
    }

    /**
     * Sets the transmission type of the car.
     * Validates that the transmission type is either "Manual" or "Automatic".
     *
     * @param transmissionType the new transmission type
     * @throws IllegalArgumentException if the transmission type is invalid
     */
    public void setTransmissionType(String transmissionType) {
        if (!transmissionType.equalsIgnoreCase("Manual") && !transmissionType.equalsIgnoreCase("Automatic")) {
            throw new IllegalArgumentException("Invalid transmission type");
        }
        this.transmissionType = transmissionType;
    }

    /**
     * Sets the trunk capacity of the car in litres.
     * Validates that the trunk capacity is greater than 0 and less than or equal to 1000.
     *
     * @param trunkCapacity the new trunk capacity in litres
     * @throws IllegalArgumentException if the trunk capacity is invalid
     */
    public void setTrunkCapacity(double trunkCapacity) {
        if (trunkCapacity < 0 || trunkCapacity > 1000) {
            throw new IllegalArgumentException("Trunk capacity must be greater than 0 and  less or equal to 1000 litres");
        }
        this.trunkCapacity = trunkCapacity;
    }

    /**
     * Sets the mileage of the car.
     * Validates that the mileage is between 0 and 1,000,000 kilometers.
     *
     * @param mileage the new mileage in kilometers
     * @throws IllegalArgumentException if the mileage is invalid
     */
    public void setMileage(double mileage) {
        if (mileage < 0 || mileage > 1000000){
            throw new IllegalArgumentException("Mileage must be between 0 and 1,000,000");
        }
        this.mileage = mileage;
    }

    /**
     * Calculates the rental cost for the car based on the number of days rented.
     *
     * @param days the number of days the car is rented
     * @return the total rental cost for the specified number of days
     * @throws IllegalArgumentException if the number of rental days is not positive
     *
     * @note Future development may include implementing pricing strategies based on peak seasons
     *       or additional surcharges for special features.
     */
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Rentals days must be positive");
        }
        return days * getBaseRentalRate();
        // TODO: Implement dynamic pricing (e.g., weekend pricing, seasonal rates)
    }

    /**
     * Checks if the car is available for rental.
     *
     * @return {@code true} if the car is available, {@code false} otherwise
     */
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    /**
     * Checks if the car is available for rental on the given date range.
     *
     * @param startDate the start date of the rental period
     * @param endDate the end date of the rental period
     * @return {@code true} if the car is available, {@code false} otherwise
     *
     * @note Future development could involve integrating a date booking system
     *       and handling date conflicts.
     */
    public boolean isAvailableOnDate(String startDate, String endDate) {
        // TODO: Implement date-based availability check using booking system
        return true; // Placeholder for future logic
    }

    /**
     * Checks if the car is due for maintenance.
     *
     * @return {@code true} if the car is due for maintenance, {@code false} otherwise
     *
     * @note Future development may involve adding maintenance logic based on mileage
     *       or time since the last service.
     */
    public boolean isDueForMaintenance() {
        // TODO: Implement maintenance check based on mileage or last service date
        return false; // Placeholder for future logic
    }

    /**
     * Returns a string representation of the {@code Car} object.
     *
     * @return a string representing the car's attributes
     */
    @Override
    public String toString() {
        return super.toString() +
                ", seatingCapacity='" + seatingCapacity + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", trunkCapacity='" + trunkCapacity + '\'' +
                ", mileage=" + mileage;
    }

    /**
     * Checks if two {@code Car} objects are equal.
     *
     * @param o the object to compare with
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return seatingCapacity == car.seatingCapacity &&
                Double.compare(car.trunkCapacity, trunkCapacity) == 0 &&
                Double.compare(car.mileage, mileage) == 0 &&
                Objects.equals(transmissionType, car.transmissionType);
    }

    /**
     * Returns the hash code for the {@code Car} object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seatingCapacity, transmissionType, trunkCapacity, mileage);
    }
}

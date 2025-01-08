package vrs.models.vehicle;

import vrs.models.enums.FuelType;
import vrs.models.interfaces.VehicleCategory;
import vrs.models.others.Brand;

import java.util.Objects;

public class Car extends Vehicle {
    private int seatingCapacity;
    private String transmissionType;
    private double trunkCapacity;
    private double mileage;

    public Car(String vehicleId, String licensePlate, String model, Brand brand,
               FuelType fuelType, VehicleCategory vehicleCategory, double baseRentalRate,
               boolean isAvailable, int seatingCapacity, String transmissionType, double trunkCapacity, double mileage) {
        super(vehicleId, licensePlate, model, brand, fuelType, vehicleCategory, baseRentalRate,
                isAvailable);
        this.seatingCapacity = seatingCapacity;
        this.transmissionType = transmissionType;
        this.trunkCapacity = trunkCapacity;
        this.mileage = mileage;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public double getTrunkCapacity() {
        return trunkCapacity;
    }

    public double getMileage() {
        return mileage;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        if (seatingCapacity <= 0) {
            throw new IllegalArgumentException("Seating  capacity must be positive");
        }
        this.seatingCapacity = seatingCapacity;
    }

    public void setTransmissionType(String transmissionType) {
        if (!transmissionType.equalsIgnoreCase("Manual") && !transmissionType.equalsIgnoreCase("Automatic")) {
            throw new IllegalArgumentException("Invalid transmission type");
        }
        this.transmissionType = transmissionType;
    }

    public void setTrunkCapacity(double trunkCapacity) {
        if (trunkCapacity < 0) {
            throw new IllegalArgumentException("Trunk capacity cannot be negative");
        }
        this.trunkCapacity = trunkCapacity;
    }

    public void setMileage(double mileage) {
        if (mileage < 0){
            throw new IllegalArgumentException("Mileage cannot be negative");
        }
        this.mileage = mileage;
    }

    public double calculateRentalCost(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Rentals days must be positive");
        }
        return days * getBaseRentalRate();
        // Calculate rental cost based on conditions
    }

    public boolean isAvailableForRental() {
        return IsAvailable();
    }

    public boolean isAvailableOnDate() {
        // Implement date-based logic
        // Check if car is available on a given date
        return true;
    }

    public boolean isDueForMaintenance() {
        // Implement mileage or time-based maintenance logic
        return false;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", seatingCapacity='" + seatingCapacity + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", trunkCapacity='" + trunkCapacity + '\'' +
                ", mileage=" + mileage;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seatingCapacity, transmissionType, trunkCapacity, mileage);
    }
}

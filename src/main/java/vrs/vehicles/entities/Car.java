package vrs.vehicles.entities;

import vrs.vehicles.enums.FuelType;
import vrs.vehicles.interfaces.VehicleCategory;
import vrs.vehicles.others.Brand;

import java.util.Objects;

public class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String vehicleId, String licensePlate, String model, Brand brand,
               FuelType fuelType, VehicleCategory vehicleCategory, double baseRentalRate,
               boolean isAvailable, int seatingCapacity) {
        super(vehicleId, licensePlate, model, brand, fuelType, vehicleCategory, baseRentalRate,
                isAvailable);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public double calculateRentalCost(int days) {
        return days;
        // Calculate rental cost based on conditions
    }

    public boolean isAvailableForRental() {
        return IsAvailable();
    }

    public boolean isAvailableOnDate() {
        return false;
        // Yet to define method for use
    }

    public boolean isDueForMaintenance() {
        return false;
        // Yet to define the methode
    }

    @Override
    public String toString() {
        return "Car{" +
                "seatingCapacity=" + seatingCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return seatingCapacity == car.seatingCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seatingCapacity);
    }
}

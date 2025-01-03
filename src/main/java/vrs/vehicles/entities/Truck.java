package vrs.vehicles.entities;

import vrs.vehicles.enums.FuelType;
import vrs.vehicles.interfaces.VehicleCategory;
import vrs.vehicles.others.Brand;

import java.util.Objects;

public class Truck extends Vehicle {
    private double cargoCapacity;
    private int axleCount;
    private double payLoadCapacity;

    public Truck(String vehicleId, String licensePlate, String model, Brand brand, FuelType fuelType, VehicleCategory vehicleCategory,
                 double baseRentalRate, boolean isAvailable, double cargoCapacity, int axleCount, double payLoadCapacity) {
        super(vehicleId, licensePlate, model, brand, fuelType, vehicleCategory, baseRentalRate,
                isAvailable);
        if (cargoCapacity < 0) {
            throw new IllegalArgumentException("Cargo capacity must be non-negative");
        }
        if (axleCount <= 0) {
            throw new IllegalArgumentException("Axle count must be non-negative");
        }
        if (payLoadCapacity < 0) {
            throw new IllegalArgumentException("Pay load capacity must be non-negative");
        }
        this.cargoCapacity = cargoCapacity;
        this.axleCount = axleCount;
        this.payLoadCapacity = payLoadCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public int getAxleCount() {
        return axleCount;
    }

    public double getPayLoadCapacity() {
        return payLoadCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        if (cargoCapacity < 0) {
            throw new IllegalArgumentException("Cargo capacity cannot be negative");
        }
        this.cargoCapacity = cargoCapacity;
    }

    public void setAxleCount(int axleCount) {
        if (axleCount <= 0) {
            throw new IllegalArgumentException("Axle count must be non-negative");
        }
        this.axleCount = axleCount;
    }

    public void setPayLoadCapacity(double payLoadCapacity) {
        if (payLoadCapacity < 0) {
            throw new IllegalArgumentException("Pay load capacity must be non-negative");
        }
        this.payLoadCapacity = payLoadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return 0;
    }

    @Override
    public boolean isAvailableForRental() {
        return false;
    }

    @Override
    public boolean isAvailableOnDate() {
        return false;
    }

    @Override
    public boolean isDueForMaintenance() {
        return false;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", cargoCapacity='" + cargoCapacity + '\'' +
                ", axleCount='" + axleCount + '\'' +
                ", payLoadCapacity=" + payLoadCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return Double.compare(cargoCapacity, truck.cargoCapacity) == 0 &&
                Double.compare(payLoadCapacity, truck.payLoadCapacity) == 0 &&
                Objects.equals(axleCount, truck.axleCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoCapacity, axleCount, payLoadCapacity);
    }
}

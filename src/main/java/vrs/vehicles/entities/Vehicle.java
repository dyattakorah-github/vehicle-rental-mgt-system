package vrs.vehicles.entities;

import vrs.vehicles.others.Brand;
import vrs.vehicles.interfaces.VehicleCategory;
import vrs.vehicles.enums.FuelType;

import java.util.Objects;

public abstract class  Vehicle {
    private String vehicleId;
    private String licensePlate;
    private String model;
    private Brand brand;
    private FuelType fuelType;
    private VehicleCategory vehicleCategory;
    private double baseRentalRate;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String licensePlate, String model, Brand brand, FuelType fuelType, VehicleCategory vehicleCategory, double baseRentalRate, boolean isAvailable) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
        this.fuelType = fuelType;
        this.vehicleCategory = vehicleCategory;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = isAvailable;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean IsAvailable() {
        return isAvailable;
    }

    public Brand getBrand() {
        return brand;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        this.baseRentalRate = baseRentalRate;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
        brand.addVehicle(this);
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();
    public abstract boolean isAvailableOnDate();
    public abstract boolean isDueForMaintenance();

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                "licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", brand=" + brand +
                ", fuelType='" + fuelType + '\'' +
                ", vehicleCategory=" + vehicleCategory +
                ", baseRentalRate=" + baseRentalRate +
                ", isAvailable=" + isAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(baseRentalRate, vehicle.baseRentalRate) == 0 && Objects.equals(vehicleId, vehicle.vehicleId) && Objects.equals(licensePlate, vehicle.licensePlate) &&
                Objects.equals(model, vehicle.model) && Objects.equals(brand, vehicle.brand) && Objects.equals(fuelType, vehicle.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, licensePlate, model, baseRentalRate, brand, fuelType);
    }
}



package vrs.models.vehicle;

import vrs.business.RentalCostCalculator;
import vrs.models.Bookings;
import vrs.models.others.Brand;
import vrs.models.interfaces.VehicleCategory;
import vrs.models.enums.vehicle.othercategories.FuelType;

import java.time.Year;
import java.util.Objects;

public abstract class  Vehicle {
    private final String vehicleId;
    private final String licensePlate;
    private final String model;
    private Brand brand;
    private FuelType fuelType;
    private VehicleCategory vehicleCategory;
    private double baseRentalRate;
    private boolean isAvailable;

    // Constructor
    public Vehicle(String vehicleId, String licensePlate, String model, Brand brand, FuelType fuelType, VehicleCategory vehicleCategory, double baseRentalRate, boolean isAvailable) {
        if (baseRentalRate < 0) {
            throw new IllegalArgumentException("Base rental rate cannot be negative");
        }
        if (vehicleId == null || vehicleId.isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be empty");
        }
        if (licensePlate == null || licensePlate.isEmpty()) {
            throw new IllegalArgumentException("License plate cannot be empty");
        }
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }
        if (brand == null || brand.getBrandName() == null || brand.getBrandName().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        if (fuelType == null) {
            throw new IllegalArgumentException("Fuel type cannot be empty");
        }
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
        this.fuelType = fuelType;
        this.vehicleCategory = vehicleCategory;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
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

    public boolean isAvailable() {
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

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate < 0) {
            throw new IllegalArgumentException("Base rental rate cannot be negative");
        }
        this.baseRentalRate = baseRentalRate;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setBrand(Brand brand) {
        if (brand == null || brand.getBrandName() == null || brand.getBrandName().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        this.brand = brand;
        brand.addVehicle(this);
    }

    public void setFuelType(FuelType fuelType) {
        if (fuelType == null) {
            throw new IllegalArgumentException("Fuel type cannot be empty");
        }
        this.fuelType = fuelType;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public int calculateAge() {
        int currentYear = Year.now().getValue();
        return currentYear - brand.getYear();
    }

    protected abstract RentalCostCalculator createRentalCostCalculator();

    public double calculateRentalCost(Bookings booking) {
        RentalCostCalculator costCalculator = createRentalCostCalculator();
        return costCalculator.calculateRentalCost(this, booking);
    }

    /**
     * Checks whether the vehicle is currently available for rental.
     *
     * @return true if the vehicle is available for rental, otherwise false.
     */
    public abstract boolean isAvailableForRental();

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
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
        return Double.compare(baseRentalRate, vehicle.baseRentalRate) == 0 && isAvailable ==  vehicle.isAvailable &&
                Objects.equals(vehicleId, vehicle.vehicleId) && Objects.equals(licensePlate, vehicle.licensePlate) &&
                Objects.equals(model, vehicle.model) && Objects.equals(brand, vehicle.brand) &&
                Objects.equals(fuelType, vehicle.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, licensePlate, model, baseRentalRate, brand, fuelType);
    }
}



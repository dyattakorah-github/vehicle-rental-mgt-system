package vrs.models.others;

import vrs.models.enums.vehicle.vehiclecategories.CarCategory;
import vrs.models.enums.vehicle.vehiclecategories.MotorcycleCategory;
import vrs.models.enums.vehicle.vehiclecategories.TruckCategory;
import vrs.models.interfaces.VehicleCategory;
import vrs.models.vehicle.Vehicle;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Brand {
    private String brandName;
    private String countryOfOrigin;
    private int year;
    private Set<VehicleCategory> category;
    private Set<Vehicle> associatedVehicles;

    public Brand(String brandName, int year, String countryOfOrigin) {
        this.brandName = brandName;
        this.countryOfOrigin = countryOfOrigin;
        this.year = year;
        this.category = new HashSet<>();
        this.associatedVehicles = new HashSet<>();
    }

    public String getBrandName() {
        return brandName;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public int getYear() { return year; }

    public Set<VehicleCategory> getCategory() {
        return category;
    }

    public Set<Vehicle> getAssociatedVehicles() {
        return associatedVehicles;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setYear(int year) { this.year = year; }

    public void setCategory(Set<VehicleCategory> category) {
        this.category = new HashSet<>(category);
    }

    public void setAssociatedVehicles(Set<Vehicle> associatedVehicles) {
        this.associatedVehicles = new HashSet<>(associatedVehicles);
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle != null && !associatedVehicles.contains(vehicle)) {
            associatedVehicles.add(vehicle);
            vehicle.setBrand(this);
        }
    }

    public void addCategory(VehicleCategory category) {
        if (category != null) {
            if (category instanceof CarCategory || category instanceof MotorcycleCategory || category instanceof TruckCategory) {
                this.category.add(category);
            } else {
                throw new IllegalArgumentException("Only CarCategory, MotorcycleCategory or TruckCategory can be added.");
            }
        }
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandName='" + brandName + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", year='" + year + '\'' +
                ", category='" + category + '\'' +
                ", associatedVehicles=" + associatedVehicles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(brandName, brand.brandName) && Objects.equals(countryOfOrigin, brand.countryOfOrigin) &&
                Objects.equals(year, brand.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName, countryOfOrigin, year);
    }
}

package vrs.vehicles.others;

import vrs.vehicles.interfaces.VehicleCategory;
import vrs.vehicles.entities.Vehicle;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Brand {
    private String brandName;
    private String countryOfOrigin;
    private String year;
    private Set<VehicleCategory> category;
    private Set<Vehicle> associatedVehicles;

    public Brand(String brandName, String year, String countryOfOrigin) {
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

    public String getYear() { return year; }

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

    public void setYear(String year) { this.year = year; }

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
            this.category.add(category);
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

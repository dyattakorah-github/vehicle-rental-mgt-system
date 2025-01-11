package vrs.dao;

import vrs.models.vehicle.Car;
import vrs.models.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CarDAO} class implements the {@code VehicleDAO} operations specifically for {@code Car} objects.
 */
public class CarDAO extends VehicleDAO {

    private List<Car> carDatabase = new ArrayList<>();  // Simulating a database with a list

    /**
     * Saves a new car to the database.
     *
     * @param vehicle the car to save
     * @return {@code true} if the car was saved successfully, {@code false} otherwise
     */
    @Override
    public boolean save(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            carDatabase.add((Car) vehicle);
            return true;
        }
        return false;
    }

    /**
     * Updates an existing car in the database.
     *
     * @param vehicle the car with updated information
     * @return {@code true} if the car was updated successfully, {@code false} otherwise
     */
    @Override
    public boolean update(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            for (int i = 0; i < carDatabase.size(); i++) {
                if (carDatabase.get(i).getVehicleId().equals(vehicle.getVehicleId())) {
                    carDatabase.set(i, (Car) vehicle);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Deletes a car from the database based on its ID.
     *
     * @param vehicleId the ID of the car to delete
     * @return {@code true} if the car was deleted successfully, {@code false} otherwise
     */
    @Override
    public boolean delete(String vehicleId) {
        return carDatabase.removeIf(car -> car.getVehicleId().equals(vehicleId));
    }

    /**
     * Retrieves a car by its ID.
     *
     * @param vehicleId the ID of the car to retrieve
     * @return the car with the specified ID, or {@code null} if not found
     */
    @Override
    public Vehicle getById(String vehicleId) {
        for (Car car : carDatabase) {
            if (car.getVehicleId().equals(vehicleId)) {
                return car;
            }
        }
        return null;
    }

    /**
     * Retrieves a list of all cars.
     *
     * @return a list of all cars
     */
    @Override
    public List<Vehicle> getAll() {
        return new ArrayList<>(carDatabase);
    }

    /**
     * Retrieves a list of available cars.
     *
     * @return a list of available cars
     */
    @Override
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableCars = new ArrayList<>();
        for (Car car : carDatabase) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public List<Car> findCarsBySeatingCapacity(int seatingCapacity) {
        List<Car> result = new ArrayList<>();
        for (Car car : carDatabase) {
            if (car.getSeatingCapacity() == seatingCapacity) {
                result.add(car);
            }
        }
        return result;
    }

    public List<Car> findCarsByTrunkCapacityRange(double minCapacity, double maxCapacity) {
        List<Car> result = new ArrayList<>();
        for (Car car : carDatabase) {
            double capacity = car.getTrunkCapacity();
            if (capacity >= minCapacity && capacity <= maxCapacity) {
                result.add(car);
            }
        }
        return result;
    }

    public List<Car> findCarsByTransmissionType(String transmissionType) {
        List<Car> result = new ArrayList<>();
        for (Car car : carDatabase) {
            if (car.getTransmissionType().equalsIgnoreCase(transmissionType)) {
                result.add(car);
            }
        }
        return result;
    }

    public List<Car> findAvailableCarsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Car> result = new ArrayList<>();
        for (Car car : carDatabase) {
            if (car.isAvailableOnDate(startDate, endDate)) {
                result.add(car);
            }
        }
        return result;
    }


}

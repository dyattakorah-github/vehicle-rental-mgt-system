package vrs.dao;

import vrs.models.vehicle.Motorcycle;
import vrs.models.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code MotorcycleDAO} class implements the {@code VehicleDAO} operations specifically for {@code Motorcycle} objects.
 */
public class MotorcycleDAO extends VehicleDAO {

    private List<Motorcycle> motorcycleDatabase = new ArrayList<>();  // Simulating a database with a list

    /**
     * Saves a new motorcycle to the database.
     *
     * @param vehicle the motorcycle to save
     * @return {@code true} if the motorcycle was saved successfully, {@code false} otherwise
     */
    @Override
    public boolean save(Vehicle vehicle) {
        if (vehicle instanceof Motorcycle) {
            motorcycleDatabase.add((Motorcycle) vehicle);
            return true;
        }
        return false;
    }

    /**
     * Updates an existing motorcycle in the database.
     *
     * @param vehicle the motorcycle with updated information
     * @return {@code true} if the motorcycle was updated successfully, {@code false} otherwise
     */
    @Override
    public boolean update(Vehicle vehicle) {
        if (vehicle instanceof Motorcycle) {
            for (int i = 0; i < motorcycleDatabase.size(); i++) {
                if (motorcycleDatabase.get(i).getVehicleId().equals(vehicle.getVehicleId())) {
                    motorcycleDatabase.set(i, (Motorcycle) vehicle);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Deletes a motorcycle from the database based on its ID.
     *
     * @param vehicleId the ID of the motorcycle to delete
     * @return {@code true} if the motorcycle was deleted successfully, {@code false} otherwise
     */
    @Override
    public boolean delete(String vehicleId) {
        return motorcycleDatabase.removeIf(motorcycle -> motorcycle.getVehicleId().equals(vehicleId));
    }

    /**
     * Retrieves a motorcycle by its ID.
     *
     * @param vehicleId the ID of the motorcycle to retrieve
     * @return the motorcycle with the specified ID, or {@code null} if not found
     */
    @Override
    public Vehicle getById(String vehicleId) {
        for (Motorcycle motorcycle : motorcycleDatabase) {
            if (motorcycle.getVehicleId().equals(vehicleId)) {
                return motorcycle;
            }
        }
        return null;
    }

    /**
     * Retrieves a list of all motorcycles.
     *
     * @return a list of all motorcycles
     */
    @Override
    public List<Vehicle> getAll() {
        return new ArrayList<>(motorcycleDatabase);
    }

    /**
     * Retrieves a list of available motorcycles.
     *
     * @return a list of available motorcycles
     */
    @Override
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableMotorcycles = new ArrayList<>();
        for (Motorcycle motorcycle : motorcycleDatabase) {
            if (motorcycle.isAvailable()) {
                availableMotorcycles.add(motorcycle);
            }
        }
        return availableMotorcycles;
    }

    /**
     * Finds motorcycles by engine type.
     *
     * @param engineType the engine type to search for (e.g., Single-cylinder, V-twin)
     * @return a list of motorcycles with the specified engine type
     */
    public List<Motorcycle> findMotorcyclesByEngineType(String engineType) {
        List<Motorcycle> result = new ArrayList<>();
        for (Motorcycle motorcycle : motorcycleDatabase) {
            if (motorcycle.getEngineType().toString().equalsIgnoreCase(engineType)) {
                result.add(motorcycle);
            }
        }
        return result;
    }

    /**
     * Finds motorcycles by mileage range.
     *
     * @param minMileage the minimum mileage
     * @param maxMileage the maximum mileage
     * @return a list of motorcycles with mileage within the specified range
     */
    public List<Motorcycle> findMotorcyclesByMileageRange(double minMileage, double maxMileage) {
        List<Motorcycle> result = new ArrayList<>();
        for (Motorcycle motorcycle : motorcycleDatabase) {
            double mileage = motorcycle.getMileage();
            if (mileage >= minMileage && mileage <= maxMileage) {
                result.add(motorcycle);
            }
        }
        return result;
    }

    /**
     * Finds motorcycles that are available for a given date range.
     *
     * @param startDate the start date of the rental period
     * @param endDate the end date of the rental period
     * @return a list of available motorcycles for the specified date range
     */
    public List<Motorcycle> findAvailableMotorcyclesByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Motorcycle> result = new ArrayList<>();
        for (Motorcycle motorcycle : motorcycleDatabase) {
            if (motorcycle.isAvailableOnDate(startDate, endDate)) {
                result.add(motorcycle);
            }
        }
        return result;
    }
}

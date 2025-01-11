package vrs.dao;

import vrs.models.vehicle.Truck;
import vrs.models.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code TruckDAO} class implements the {@code VehicleDAO} operations specifically for {@code Truck} objects.
 */
public class TruckDAO extends VehicleDAO {

    private List<Truck> truckDatabase = new ArrayList<>();  // Simulating a database with a list

    /**
     * Saves a new truck to the database.
     *
     * @param vehicle the truck to save
     * @return {@code true} if the truck was saved successfully, {@code false} otherwise
     */
    @Override
    public boolean save(Vehicle vehicle) {
        if (vehicle instanceof Truck) {
            truckDatabase.add((Truck) vehicle);
            return true;
        }
        return false;
    }

    /**
     * Updates an existing truck in the database.
     *
     * @param vehicle the truck with updated information
     * @return {@code true} if the truck was updated successfully, {@code false} otherwise
     */
    @Override
    public boolean update(Vehicle vehicle) {
        if (vehicle instanceof Truck) {
            for (int i = 0; i < truckDatabase.size(); i++) {
                if (truckDatabase.get(i).getVehicleId().equals(vehicle.getVehicleId())) {
                    truckDatabase.set(i, (Truck) vehicle);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Deletes a truck from the database based on its ID.
     *
     * @param vehicleId the ID of the truck to delete
     * @return {@code true} if the truck was deleted successfully, {@code false} otherwise
     */
    @Override
    public boolean delete(String vehicleId) {
        return truckDatabase.removeIf(truck -> truck.getVehicleId().equals(vehicleId));
    }

    /**
     * Retrieves a truck by its ID.
     *
     * @param vehicleId the ID of the truck to retrieve
     * @return the truck with the specified ID, or {@code null} if not found
     */
    @Override
    public Vehicle getById(String vehicleId) {
        for (Truck truck : truckDatabase) {
            if (truck.getVehicleId().equals(vehicleId)) {
                return truck;
            }
        }
        return null;
    }

    /**
     * Retrieves a list of all trucks.
     *
     * @return a list of all trucks
     */
    @Override
    public List<Vehicle> getAll() {
        return new ArrayList<>(truckDatabase);
    }

    /**
     * Retrieves a list of available trucks.
     *
     * @return a list of available trucks
     */
    @Override
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableTrucks = new ArrayList<>();
        for (Truck truck : truckDatabase) {
            if (truck.isAvailable()) {
                availableTrucks.add(truck);
            }
        }
        return availableTrucks;
    }

    /**
     * Finds trucks with a specific cargo capacity.
     */
    public List<Truck> findTrucksByCargoCapacity(double cargoCapacity) {
        List<Truck> result = new ArrayList<>();
        for (Truck truck : truckDatabase) {
            if (truck.getCargoCapacity() == cargoCapacity) {
                result.add(truck);
            }
        }
        return result;
    }

    /**
     * Finds trucks within a specific cargo bed size range.
     */
    public List<Truck> findTrucksByCargoBedSizeRange(double minSize, double maxSize) {
        List<Truck> result = new ArrayList<>();
        for (Truck truck : truckDatabase) {
            double size = truck.getCargoBedSize();
            if (size >= minSize && size <= maxSize) {
                result.add(truck);
            }
        }
        return result;
    }

    /**
     * Finds trucks with a specific axle count.
     */
    public List<Truck> findTrucksByAxleCount(int axleCount) {
        List<Truck> result = new ArrayList<>();
        for (Truck truck : truckDatabase) {
            if (truck.getAxleCount() == axleCount) {
                result.add(truck);
            }
        }
        return result;
    }

    /**
     * Finds trucks available within a specific date range.
     */
    public List<Truck> findAvailableTrucksByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Truck> result = new ArrayList<>();
        for (Truck truck : truckDatabase) {
            if (truck.isAvailableOnDate(startDate, endDate)) {
                result.add(truck);
            }
        }
        return result;
    }
}

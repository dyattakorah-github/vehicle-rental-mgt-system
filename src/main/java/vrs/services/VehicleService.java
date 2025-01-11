package vrs.services;

import vrs.dao.VehicleDAO;
import vrs.models.vehicle.Vehicle;
import java.util.List;

/**
 * The {@code VehicleService} class provides business logic and operations for handling vehicles.
 */
public class VehicleService {

    private VehicleDAO vehicleDAO;

    // Constructor to initialize the VehicleDAO
    public VehicleService(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    /**
     * Adds a new vehicle to the system.
     *
     * @param vehicle the vehicle to add
     * @return {@code true} if the vehicle was added successfully, {@code false} otherwise
     */
    public boolean addVehicle(Vehicle vehicle) {
        try {
            return vehicleDAO.save(vehicle);
        } catch (Exception e) {
            System.out.println("Error adding vehicle: " + e.getMessage());
            return false;
        }
    }

    /**
     * Updates an existing vehicle in the system.
     *
     * @param vehicle the vehicle with updated information
     * @return {@code true} if the vehicle was updated successfully, {@code false} otherwise
     */
    public boolean updateVehicle(Vehicle vehicle) {
        try {
            return vehicleDAO.update(vehicle);
        } catch (Exception e) {
            System.out.println("Error updating vehicle: " + e.getMessage());
            return false;
        }
    }

    /**
     * Deletes a vehicle by its ID (cancels the vehicle from the system).
     *
     * @param vehicleId the ID of the vehicle to delete
     * @return {@code true} if the vehicle was deleted successfully, {@code false} otherwise
     */
    public boolean cancelVehicle(String vehicleId) {
        try {
            return vehicleDAO.delete(vehicleId);
        } catch (Exception e) {
            System.out.println("Error canceling vehicle: " + e.getMessage());
            return false;
        }
    }

    /**
     * Retrieves a vehicle by its ID.
     *
     * @param vehicleId the ID of the vehicle to retrieve
     * @return the vehicle if found, {@code null} otherwise
     */
    public Vehicle getVehicleById(String vehicleId) {
        return vehicleDAO.getById(vehicleId);
    }

    /**
     * Retrieves all vehicles in the system.
     *
     * @return a list of all vehicles
     */
    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.getAll();
    }

    /**
     * Retrieves a list of available vehicles.
     *
     * @return a list of available vehicles
     */
    public List<Vehicle> getAvailableVehicles() {
        return vehicleDAO.getAvailableVehicles();
    }
}

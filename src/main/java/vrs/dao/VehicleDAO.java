package vrs.dao;

import vrs.models.vehicle.Vehicle;

import java.util.List;

/**
 * The {@code VehicleDAO} class is an abstract class that defines the common operations for managing vehicles.
 * Subclasses will implement these operations for specific vehicle types (e.g., {@code CarDAO}, {@code TruckDAO}).
 */
public abstract class VehicleDAO {

    /**
     * Saves a new vehicle to the database.
     *
     * @param vehicle the vehicle to save
     * @return {@code true} if the vehicle was saved successfully, {@code false} otherwise
     */
    public abstract boolean save(Vehicle vehicle);

    /**
     * Updates an existing vehicle in the database.
     *
     * @param vehicle the vehicle with updated information
     * @return {@code true} if the vehicle was updated successfully, {@code false} otherwise
     */
    public abstract boolean update(Vehicle vehicle);

    /**
     * Deletes a vehicle from the database based on its ID.
     *
     * @param vehicleId the ID of the vehicle to delete
     * @return {@code true} if the vehicle was deleted successfully, {@code false} otherwise
     */
    public abstract boolean delete(String vehicleId);

    /**
     * Retrieves a vehicle by its ID.
     *
     * @param vehicleId the ID of the vehicle to retrieve
     * @return the vehicle with the specified ID, or {@code null} if not found
     */
    public abstract Vehicle getById(String vehicleId);

    /**
     * Retrieves a list of all vehicles.
     *
     * @return a list of all vehicles
     */
    public abstract List<Vehicle> getAll();

    /**
     * Retrieves a list of available vehicles.
     *
     * @return a list of available vehicles
     */
    public abstract List<Vehicle> getAvailableVehicles();
}

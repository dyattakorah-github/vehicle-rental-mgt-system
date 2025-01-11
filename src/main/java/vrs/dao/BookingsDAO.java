package vrs.dao;

import vrs.models.Bookings;
import vrs.models.Customer;
import vrs.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The {@code BookingsDAO} class implements the operations specifically for {@code Bookings} objects.
 */
public class BookingsDAO {

    private List<Bookings> bookingsDatabase = new ArrayList<>();  // Simulating a database with a list

    /**
     * Saves a new booking to the database.
     *
     * @param booking the booking to save
     * @return {@code true} if the booking was saved successfully, {@code false} otherwise
     */
    public boolean save(Bookings booking) {
        if (booking != null) {
            bookingsDatabase.add(booking);
            return true;
        }
        return false;
    }

    /**
     * Updates an existing booking in the database.
     *
     * @param booking the booking with updated information
     * @return {@code true} if the booking was updated successfully, {@code false} otherwise
     */
    public boolean update(Bookings booking) {
        for (int i = 0; i < bookingsDatabase.size(); i++) {
            if (bookingsDatabase.get(i).equals(booking)) {
                bookingsDatabase.set(i, booking);
                return true;
            }
        }
        return false;
    }

    /**
     * Cancels a booking made by a specific customer for a specific vehicle.
     *
     * @param vehicle the vehicle associated with the booking
     * @param customer the customer who made the booking
     * @return {@code true} if the booking was canceled successfully, {@code false} otherwise
     */
    public boolean cancel(Vehicle vehicle, Customer customer) {
        Optional<Bookings> bookingToCancel = bookingsDatabase.stream()
                .filter(b -> b.getVehicle().equals(vehicle) && b.getCustomer().equals(customer))
                .findFirst();

        if (bookingToCancel.isPresent()) {
            bookingsDatabase.remove(bookingToCancel.get());
            return true;
        }
        return false;
    }

    /**
     * Retrieves a booking by its associated vehicle and customer.
     *
     * @param vehicle the vehicle associated with the booking
     * @param customerId the ID of the customer associated with the booking
     * @return the booking with the specified vehicle and customer, or {@code null} if not found
     */
    public Bookings getByVehicleAndCustomer(Vehicle vehicle, String customerId) {
        for (Bookings booking : bookingsDatabase) {
            // Ensure we're correctly comparing the customerId with the customer's ID in the booking
            if (booking.getVehicle().equals(vehicle) && booking.getCustomer().getCustomerId().equals(customerId)) {
                return booking;
            }
        }
        return null;
    }


    /**
     * Retrieves all bookings in the system.
     *
     * @return a list of all bookings
     */
    public List<Bookings> getAll() {
        return new ArrayList<>(bookingsDatabase);
    }

    /**
     * Retrieves a list of bookings for a specific vehicle.
     *
     * @param vehicle the vehicle for which to retrieve bookings
     * @return a list of bookings for the specified vehicle
     */
    public List<Bookings> getBookingsByVehicle(Vehicle vehicle) {
        List<Bookings> result = new ArrayList<>();
        for (Bookings booking : bookingsDatabase) {
            if (booking.getVehicle().equals(vehicle)) {
                result.add(booking);
            }
        }
        return result;
    }

    /**
     * Retrieves a list of bookings for a specific customer.
     *
     * @param customerId the customer ID for which to retrieve bookings
     * @return a list of bookings for the specified customer
     */
    public List<Bookings> getBookingsByCustomer(String customerId) {
        List<Bookings> result = new ArrayList<>();
        for (Bookings booking : bookingsDatabase) {
            if (booking.getCustomer().getCustomerId().equals(customerId)) {
                result.add(booking);
            }
        }
        return result;
    }

    /**
     * Checks if a booking exists for a specific vehicle and customer.
     *
     * @param vehicle the vehicle associated with the booking
     * @param customerId the customer ID associated with the booking
     * @return {@code true} if the booking exists, {@code false} otherwise
     */
    public boolean bookingExists(Vehicle vehicle, String customerId) {
        return bookingsDatabase.stream().anyMatch(b -> b.getVehicle().equals(vehicle) && b.getCustomer().getCustomerId().equals(customerId));
    }
}

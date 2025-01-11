package vrs.services;

import vrs.dao.BookingsDAO;
import vrs.models.Bookings;
import vrs.models.Customer;
import vrs.models.vehicle.Vehicle;

import java.util.List;

public class BookingsService {

    private final BookingsDAO bookingsDAO;

    public BookingsService(BookingsDAO bookingsDAO) {
        this.bookingsDAO = bookingsDAO;
    }

    /**
     * Saves a new booking to the system.
     *
     * @param booking the booking to save
     * @return {@code true} if the booking was saved successfully, {@code false} otherwise
     */
    public boolean saveBooking(Bookings booking) {
        return bookingsDAO.save(booking);
    }

    /**
     * Updates an existing booking in the system.
     *
     * @param booking the booking to update
     * @return {@code true} if the booking was updated successfully, {@code false} otherwise
     */
    public boolean updateBooking(Bookings booking) {
        return bookingsDAO.update(booking);
    }

    /**
     * Cancels a booking made by a specific customer for a specific vehicle.
     *
     * @param vehicle the vehicle associated with the booking
     * @param customer the customer who made the booking
     * @return {@code true} if the booking was canceled successfully, {@code false} otherwise
     */
    public boolean cancelBooking(Vehicle vehicle, Customer customer) {
        return bookingsDAO.cancel(vehicle, customer);
    }

    /**
     * Retrieves a booking by its associated vehicle and customer.
     *
     * @param vehicle the vehicle associated with the booking
     * @param customerId the customer ID associated with the booking
     * @return the booking with the specified vehicle and customer, or {@code null} if not found
     */
    public Bookings getBookingByVehicleAndCustomer(Vehicle vehicle, String customerId) {
        return bookingsDAO.getByVehicleAndCustomer(vehicle, customerId);
    }

    /**
     * Retrieves all bookings in the system.
     *
     * @return a list of all bookings
     */
    public List<Bookings> getAllBookings() {
        return bookingsDAO.getAll();
    }

    /**
     * Retrieves a list of bookings for a specific vehicle.
     *
     * @param vehicle the vehicle for which to retrieve bookings
     * @return a list of bookings for the specified vehicle
     */
    public List<Bookings> getBookingsByVehicle(Vehicle vehicle) {
        return bookingsDAO.getBookingsByVehicle(vehicle);
    }

    /**
     * Retrieves a list of bookings for a specific customer.
     *
     * @param customerId the customer ID for which to retrieve bookings
     * @return a list of bookings for the specified customer
     */
    public List<Bookings> getBookingsByCustomer(String customerId) {
        return bookingsDAO.getBookingsByCustomer(customerId);
    }

    /**
     * Checks if a booking exists for a specific vehicle and customer.
     *
     * @param vehicle the vehicle associated with the booking
     * @param customerId the customer ID associated with the booking
     * @return {@code true} if the booking exists, {@code false} otherwise
     */
    public boolean bookingExists(Vehicle vehicle, String customerId) {
        return bookingsDAO.bookingExists(vehicle, customerId);
    }
}

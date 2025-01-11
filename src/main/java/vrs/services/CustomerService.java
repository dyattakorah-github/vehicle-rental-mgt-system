package vrs.services;

import vrs.dao.CustomerDAO;
import vrs.models.Customer;
import vrs.models.Bookings;
import java.util.List;
import java.util.Optional;

/**
 * The {@code CustomerService} class provides business logic and operations for handling customers.
 */
public class CustomerService {

    private CustomerDAO customerDAO;

    // Constructor initializes the CustomerDAO
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    /**
     * Registers a new customer by saving the customer details to the database.
     *
     * @param customer the customer to register
     */
    public void registerCustomer(Customer customer) {
        try {
            customerDAO.saveCustomer(customer);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error registering customer: " + e.getMessage());
        }
    }

    /**
     * Updates the details of an existing customer.
     *
     * @param customer the customer with updated details
     */
    public void updateCustomer(Customer customer) {
        try {
            customerDAO.updateCustomer(customer);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error updating customer: " + e.getMessage());
        }
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param customerId the ID of the customer to retrieve
     * @return the customer if found, {@code null} if not found
     */
    public Customer getCustomerById(String customerId) {
        Optional<Customer> customerOpt = customerDAO.findCustomerById(customerId);
        return customerOpt.orElse(null);  // Return customer or null if not found
    }

    /**
     * Deletes a customer by their ID (cancels the customer's registration).
     *
     * @param customerId the ID of the customer to delete
     */
    public void cancelCustomer(String customerId) {
        try {
            customerDAO.deleteCustomer(customerId);
        } catch (IllegalStateException e) {
            System.out.println("Error canceling customer: " + e.getMessage());
        }
    }

    /**
     * Adds a booking to a customer's rental history.
     *
     * @param customerId the ID of the customer
     * @param booking the booking to add
     */
    public void addBookingToHistory(String customerId, Bookings booking) {
        try {
            customerDAO.addBookingToCustomerHistory(customerId, booking);
        } catch (IllegalStateException e) {
            System.out.println("Error adding booking: " + e.getMessage());
        }
    }

    /**
     * Retrieves all bookings for a specific customer.
     *
     * @param customerId the ID of the customer
     * @return a list of the customer's bookings
     */
    public List<Bookings> getCustomerBookings(String customerId) {
        try {
            return customerDAO.getCustomerBookings(customerId);
        } catch (IllegalStateException e) {
            System.out.println("Error fetching bookings: " + e.getMessage());
            return null;
        }
    }

    /**
     * Retrieves all customers in the system.
     *
     * @return a list of all customers
     */
    public List<Customer> getAllCustomers() {
        return customerDAO.findAllCustomers();
    }
}

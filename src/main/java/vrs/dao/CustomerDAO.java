package vrs.dao;

import vrs.models.Customer;
import vrs.models.Bookings;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAO {
    // In-memory database simulation
    private Map<String, Customer> customerDatabase = new HashMap<>();

    // Save or register a new customer
    public void saveCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        if (customerDatabase.containsKey(customer.getCustomerId())) {
            throw new IllegalStateException("Customer with ID " + customer.getCustomerId() + " already exists.");
        }
        customerDatabase.put(customer.getCustomerId(), customer);
        System.out.println("Customer registered successfully: " + customer);
    }

    // Find customer by ID, return Optional to handle missing customer better
    public Optional<Customer> findCustomerById(String customerId) {
        return Optional.ofNullable(customerDatabase.get(customerId));
    }

    // Update an existing customer's information
    public void updateCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        if (!customerDatabase.containsKey(customer.getCustomerId())) {
            throw new IllegalStateException("Customer with ID " + customer.getCustomerId() + " does not exist.");
        }
        customerDatabase.put(customer.getCustomerId(), customer);
        System.out.println("Customer updated successfully: " + customer);
    }

    // Delete a customer from the database
    public void deleteCustomer(String customerId) {
        if (!customerDatabase.containsKey(customerId)) {
            throw new IllegalStateException("Customer with ID " + customerId + " does not exist.");
        }
        customerDatabase.remove(customerId);
        System.out.println("Customer with ID " + customerId + " has been deleted.");
    }

    // Retrieve all customers
    public List<Customer> findAllCustomers() {
        return new ArrayList<>(customerDatabase.values());
    }

    // Add a booking to a customer's rental history
    public void addBookingToCustomerHistory(String customerId, Bookings booking) {
        Optional<Customer> customerOpt = findCustomerById(customerId);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            customer.addBookingToHistory(booking);
            System.out.println("Booking added to customer " + customerId + "'s history.");
        } else {
            throw new IllegalStateException("Customer with ID " + customerId + " not found.");
        }
    }

    // Get all bookings for a customer
    public List<Bookings> getCustomerBookings(String customerId) {
        Optional<Customer> customerOpt = findCustomerById(customerId);
        if (customerOpt.isPresent()) {
            return customerOpt.get().getRentalHistory();
        } else {
            throw new IllegalStateException("Customer with ID " + customerId + " not found.");
        }
    }
}

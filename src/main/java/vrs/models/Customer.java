package vrs.models;

import vrs.models.enums.customer.ContactType;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Customer {
    private final String customerId;
    private final String customerName;
    private final String licenseNumber;
    private Map<ContactType, String> contactInfo;
    private final List<Bookings> rentalHistory;

    public Customer(String customerId, String customerName, String licenseNumber) {
        if (customerId == null || customerId.isEmpty()) throw new IllegalArgumentException("ID cannot be null or empty");
        if (customerName == null || customerName.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if (licenseNumber == null || licenseNumber.isEmpty())
            throw new IllegalArgumentException("License number cannot be null or empty");this.customerId = customerId;
        this.customerName = customerName;
        this.licenseNumber = licenseNumber;
        this.contactInfo = new HashMap<>();
        this.rentalHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }
     public String getCustomerName() {
         return customerName;
     }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public Map<ContactType, String> getContactInfo() {
        return contactInfo;
    }

    public List<Bookings> getRentalHistory() {
        return rentalHistory;
    }

    public void setContactInfo(Map<ContactType, String> contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void addBookingToHistory(Bookings booking) {
        if (booking != null) {
            rentalHistory.add(booking);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", rentalHistory=" + rentalHistory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(customerName, customer.customerName) && Objects.equals(licenseNumber, customer.licenseNumber) && Objects.equals(contactInfo, customer.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, licenseNumber, contactInfo);
    }
}

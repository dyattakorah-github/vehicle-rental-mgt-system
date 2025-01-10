package vrs.models;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Customer {
    private final String customerId;
    private final String customerName;
    private final String licenseNumber;
    private Map<String, String> contactInfo;

    public Customer(String customerId, String customerName, String licenseNumber) {
        if (customerId == null || customerId.isEmpty()) throw new IllegalArgumentException("ID cannot be null or empty");
        if (customerName == null || customerName.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if (licenseNumber == null || licenseNumber.isEmpty())
            throw new IllegalArgumentException("License number cannot be null or empty");this.customerId = customerId;
        this.customerName = customerName;
        this.licenseNumber = licenseNumber;
        this.contactInfo = new HashMap<>();
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

    public Map<String, String> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Map<String, String> contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", contactInfo=" + contactInfo +
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

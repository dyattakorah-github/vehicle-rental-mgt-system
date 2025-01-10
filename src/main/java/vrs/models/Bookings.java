package vrs.models;

import vrs.models.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Bookings {
    private Vehicle vehicle;
    private Customer customer;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;

    public Bookings(Vehicle vehicle, Customer customer, LocalDateTime rentalDate, LocalDateTime returnDate) {
        if (vehicle == null || customer == null || rentalDate == null || returnDate == null) {
            throw new IllegalArgumentException("Booking Details cannot be empty");
        }
        if (returnDate.isBefore(rentalDate)) {
            throw new IllegalArgumentException("Return date cannot be before rentalDate");
        }
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public long calculateRentalDuration() {
        return ChronoUnit.DAYS.between(rentalDate, returnDate);
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "vehicle=" + vehicle +
                ", customer=" + customer +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookings bookings = (Bookings) o;
        return Objects.equals(vehicle, bookings.vehicle) && Objects.equals(customer, bookings.customer) && Objects.equals(rentalDate, bookings.rentalDate) && Objects.equals(returnDate, bookings.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicle, customer, rentalDate, returnDate);
    }
}

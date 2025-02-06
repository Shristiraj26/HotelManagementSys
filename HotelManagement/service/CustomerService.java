package com.cts.HotelManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.HotelManagement.entity.Customer;
import com.cts.HotelManagement.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Get all checked-in customers
    public List<Customer> getCheckedInCustomers() {
        return customerRepository.findByStatus("Checked-in");
    }

    // Save new check-in
    public void checkInCustomer(String name, String mobile, String email, LocalDate checkInDate, String roomType, String bedType, String roomNumber) {
        Customer newCustomer = new Customer(name, mobile, email, checkInDate, roomType, bedType, "Checked-in", roomNumber);
        customerRepository.save(newCustomer);
    }

    // Checkout customer
    public void checkOutCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setStatus("Checked-out");
            customerRepository.save(customer);
        }
    }
}

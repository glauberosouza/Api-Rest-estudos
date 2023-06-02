package com.store.java.demo.service;

import com.store.java.demo.entity.Address;
import com.store.java.demo.entity.Customer;
import com.store.java.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(Long customerId) {

        return customerRepository.findById(customerId).
                orElseThrow(() -> new NoSuchElementException("CustomerId "+ customerId + " not founded"));
    } // -> NoSuchElementException

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer, Long customerId) {
        Customer updatedCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer " + customerId + " not founded"));

        updatedCustomer.setFirstName(customer.getFirstName());
        updatedCustomer.setLastName(customer.getLastName());
        updatedCustomer.setPassword(customer.getPassword());

        Address address = new Address();
        address.setZipCode(customer.getAddress().getZipCode());
        address.setStreet(customer.getAddress().getStreet());
        return updatedCustomer;
    }

    public void deleteCustomer(Long customerId) {

        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            Customer customerFound = customer.get();
            customerRepository.delete(customerFound);
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }
}
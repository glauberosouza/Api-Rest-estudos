package com.store.java.demo.controller;

import com.store.java.demo.dto.CustomerDto;
import com.store.java.demo.dto.response.CustomerViewDto;
import com.store.java.demo.entity.Address;
import com.store.java.demo.entity.Customer;
import com.store.java.demo.repository.CustomerRepository;
import com.store.java.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    CustomerService customerService;
    CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public ResponseEntity<CustomerViewDto> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customerSaved = customerService.saveCustomer(customerDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(new CustomerViewDto(customerSaved));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerViewDto> findCustomerById(@PathVariable Long customerId) {
        Customer customerById = customerService.findCustomerById(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(new CustomerViewDto(customerById));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerViewDto> updateCustomer(@RequestBody CustomerDto customerDto,
                                                          @PathVariable Long customerId) {
        Customer customerUpdate = customerService.findCustomerById(customerId);
        customerUpdate.setFirstName(customerDto.getFirstName());
        customerUpdate.setLastName(customerDto.getLastName());
        customerUpdate.setPassword(customerDto.getPassword());

        Address address = customerUpdate.getAddress();
        address.setZipCode(customerUpdate.getAddress().getZipCode());
        address.setStreet(customerUpdate.getAddress().getStreet());
        Customer savedCustomer = customerRepository.save(customerUpdate);


        return ResponseEntity.status(HttpStatus.OK).body(new CustomerViewDto(savedCustomer));
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId){
        customerRepository.deleteById(customerId);
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted");
    }
}
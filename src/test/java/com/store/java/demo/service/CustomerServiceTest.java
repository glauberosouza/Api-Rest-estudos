package com.store.java.demo.service;

import com.store.java.demo.entity.Address;
import com.store.java.demo.entity.Customer;
import com.store.java.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;


    @Test
    public void shouldCreateACustomer() {
        //GIVEN
        Customer customerTest = builderCustomer();
        when(customerRepository.save(any())).thenReturn(customerTest);
        //WHEN
        Customer customerValid = customerService.saveCustomer(customerTest);
        //THEN
        Assertions.assertNotNull(customerTest);
        Assertions.assertSame(customerTest, customerValid);
        verify(customerRepository, times(1)).save(customerTest);
    }

    @Test
    public void shouldFindCustomerById() {
        //GIVEN
        long idCustomerTest = new Random().nextLong();
        Customer customerTest = builderCustomer(idCustomerTest);
        when(customerRepository.findById(idCustomerTest)).thenReturn(Optional.of(customerTest));
        //WHEN
        Customer customerValid = customerService.findCustomerById(idCustomerTest);
        //THEN
        Assertions.assertNotNull(customerTest);
        Assertions.assertSame(customerValid, customerTest);
        verify(customerRepository, times(1)).findById(idCustomerTest);
    }

    @Test
    public void shouldDeleteCustomerById() {
        //GIVEN
        long idCustomerTest = 1L;
        Customer customerTest = builderCustomer(idCustomerTest);
        when(customerRepository.findById(idCustomerTest)).thenReturn(Optional.of(customerTest));
        //WHEN
        customerService.deleteCustomer(idCustomerTest);
        //THEN
        verify(customerRepository, times(1)).findById(idCustomerTest);
        verify(customerRepository, times(1)).delete(customerTest);
    }
    @Test
    public void dontDeleteCustomerById(){
        //GIVEN
        long fakeId = 1L;
        when(customerRepository.findById(fakeId)).thenReturn(Optional.empty());
        //WHEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.deleteCustomer(fakeId));
        //THEN
        verify(customerRepository, never()).deleteById(any());
    }


    private Customer builderCustomer(
            long id,
            String firstName,
            String lastName,
            String cpf,
            BigDecimal income,
            String email,
            String password,
            String zipCode,
            String street) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setCpf(cpf);
        customer.setIncome(income);
        customer.setEmail(email);
        customer.setPassword(password);
        Address address = new Address();
        address.setZipCode(zipCode);
        address.setStreet(street);
        customer.setAddress(address);
        return customer;
    }

    private Customer builderCustomer() {
        return builderCustomer(
                1, "Glauber", "Souza",
                "28475934625", BigDecimal.valueOf(1000.0), "glauber@email", "123456",
                "000000", "Rua do Glauber 123");
    }

    private Customer builderCustomer(long id) {
        return builderCustomer(
                id, "Glauber", "Souza",
                "28475934625", BigDecimal.valueOf(1000.0), "glauber@email", "123456",
                "000000", "Rua do Glauber 123");
    }

}

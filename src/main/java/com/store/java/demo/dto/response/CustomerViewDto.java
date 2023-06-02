package com.store.java.demo.dto.response;

import com.store.java.demo.entity.Customer;

import java.math.BigDecimal;

public class CustomerViewDto {
    public Long id;
    public String firstName;
    public String lastName;
    public String cpf;
    public BigDecimal income;
    public String email;
    public String password;
    private String zipCode;
    private String street;

    public CustomerViewDto(Long id, String firstName, String lastName, String cpf, BigDecimal income, String email, String password, String zipCode, String street) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.income = income;
        this.email = email;
        this.password = password;
        this.zipCode = zipCode;
        this.street = street;
    }

    public CustomerViewDto(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.cpf = customer.getCpf();
        this.income = customer.getIncome();
        this.email = customer.getEmail();
        this.password = customer.getPassword();;
        this.zipCode = customer.getAddress().getZipCode();
        this.street = customer.getAddress().getStreet();
    }
}

package com.store.java.demo.dto;


import com.store.java.demo.entity.Address;
import com.store.java.demo.entity.Customer;

import java.math.BigDecimal;

public class CustomerDto {
    private String firstName;
    private String lastName;
    private String cpf;
    private BigDecimal income;
    private String email;
    private String password;
    private String zipCode;
    private String street;

    public CustomerDto() {
    }

    public CustomerDto(String firstName, String lastName, String cpf, BigDecimal income, String email, String password, String zipCode, String street) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.income = income;
        this.email = email;
        this.password = password;
        this.zipCode = zipCode;
        this.street = street;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public Customer toEntity() {
        return new Customer(
                this.firstName,
                this.lastName,
                this.cpf,
                this.income,
                this.email,
                this.password,
                new Address(
                        this.zipCode,
                        this.street)
        );
    }
}

package com.telecom.phonenumber.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PhoneNumber {

    @NotBlank(message = "Phone number cannot be blank")
    private final String number;

    @NotBlank(message = "Customer ID cannot be blank")
    private final String customerId;

    @NotNull(message = "Status cannot be null")
    private PhoneNumberStatus status;

    public PhoneNumber(String number, String customerId, PhoneNumberStatus status) {
        this.number = number;
        this.customerId = customerId;
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public String getCustomerId() {
        return customerId;
    }

    public PhoneNumberStatus getStatus() {
        return status;
    }

    public void setStatus(PhoneNumberStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "PhoneNumber{number='%s', customerId='%s', status=%s}",
                number, customerId, status
        );
    }
}

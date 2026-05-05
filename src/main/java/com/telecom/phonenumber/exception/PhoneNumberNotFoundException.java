package com.telecom.phonenumber.exception;

public class PhoneNumberNotFoundException extends RuntimeException {
    public PhoneNumberNotFoundException(String message)
    {
        super(message);
    }
}

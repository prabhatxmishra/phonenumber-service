package com.telecom.phonenumber.repository;

import com.telecom.phonenumber.model.PhoneNumber;

import java.util.List;
import java.util.Optional;

public interface PhoneNumberRepository {
    List<PhoneNumber> findAll();

    List<PhoneNumber> findByCustomerId(String customerId);

    Optional<PhoneNumber> findByNumber(String number);
}

package com.telecom.phonenumber.service;
import com.telecom.phonenumber.model.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {

    List<PhoneNumber> getAllPhoneNumbers();

    List<PhoneNumber> getPhoneNumbersByCustomerId(String customerId);

    PhoneNumber activatePhoneNumber(String number);

}

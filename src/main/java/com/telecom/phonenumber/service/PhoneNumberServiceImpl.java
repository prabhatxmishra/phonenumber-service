package com.telecom.phonenumber.service;

import com.telecom.phonenumber.model.PhoneNumber;
import com.telecom.phonenumber.model.PhoneNumberStatus;
import com.telecom.phonenumber.repository.PhoneNumberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService{

    private final PhoneNumberRepository repository;

    public PhoneNumberServiceImpl(PhoneNumberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PhoneNumber> getAllPhoneNumbers() {
        return repository.findAll();
    }

    @Override
    public List<PhoneNumber> getPhoneNumbersByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public PhoneNumber activatePhoneNumber(String number) {
        PhoneNumber phone = repository.findByNumber(number)
                .orElseThrow(() -> new RuntimeException("Phone number not found"));

        if (phone.getStatus() != PhoneNumberStatus.ACTIVE) {
            phone.setStatus(PhoneNumberStatus.ACTIVE);
        }

        return phone;
    }
}

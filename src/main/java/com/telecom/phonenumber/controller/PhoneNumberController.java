package com.telecom.phonenumber.controller;

import com.telecom.phonenumber.model.PhoneNumber;
import com.telecom.phonenumber.service.PhoneNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhoneNumberController {

    private final PhoneNumberService service;

    public PhoneNumberController(PhoneNumberService service) {
        this.service = service;
    }

    @GetMapping("/phone-numbers")
    public List<PhoneNumber> getAll() {
        return service.getAllPhoneNumbers();
    }

    @GetMapping("/customers/{customerId}/phone-numbers")
    public List<PhoneNumber> getByCustomer(@PathVariable String customerId) {
        return service.getPhoneNumbersByCustomerId(customerId);
    }

    @PutMapping("/phone-numbers/{number}/activate")
    public ResponseEntity<PhoneNumber> activate(@PathVariable String number) {
        PhoneNumber phone=service.activatePhoneNumber(number);
        return ResponseEntity.status(HttpStatus.OK).body(phone);
    }
}

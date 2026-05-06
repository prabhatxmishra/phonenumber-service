package com.telecom.phonenumber.service;

import com.telecom.phonenumber.exception.PhoneNumberNotFoundException;
import com.telecom.phonenumber.model.PhoneNumber;
import com.telecom.phonenumber.model.PhoneNumberStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneNumberServiceTest {

    @Autowired
    private PhoneNumberService service;

    @Test
    void testActivatePhoneNumber() {
        PhoneNumber phone = service.activatePhoneNumber("9453987987");
        assertEquals(PhoneNumberStatus.ACTIVE, phone.getStatus());
        assertEquals("9453987987", phone.getNumber());
    }

    @Test
    void testActivatePhoneNumber_NotFound() {
        assertThrows(PhoneNumberNotFoundException.class, () -> {
            service.activatePhoneNumber("9999999999");
        });
    }
}
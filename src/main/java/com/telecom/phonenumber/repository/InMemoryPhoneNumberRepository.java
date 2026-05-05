package com.telecom.phonenumber.repository;

import com.telecom.phonenumber.model.PhoneNumber;
import com.telecom.phonenumber.model.PhoneNumberStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryPhoneNumberRepository implements PhoneNumberRepository {

    private final Map<String, PhoneNumber> store = new ConcurrentHashMap<>();

    public InMemoryPhoneNumberRepository() {
        seedData();
    }


    private void seedData() {
        List<PhoneNumber> initial = List.of(
                new PhoneNumber("9455773745", "C001", PhoneNumberStatus.ACTIVE),
                new PhoneNumber("9453987987", "C001", PhoneNumberStatus.INACTIVE),
                new PhoneNumber("9451279394", "C002", PhoneNumberStatus.ACTIVE),
                new PhoneNumber("6308876116", "C002", PhoneNumberStatus.INACTIVE),
                new PhoneNumber("8736567678", "C003", PhoneNumberStatus.INACTIVE)
        );
        initial.forEach(pn -> store.put(pn.getNumber(), pn));
    }


    @Override
    public List<PhoneNumber> findAll() {
        return List.copyOf(store.values());
    }

    @Override
    public List<PhoneNumber> findByCustomerId(String customerId) {
        return store.values().stream()
                .filter(pn -> pn.getCustomerId().equals(customerId))
                .toList();
    }

    @Override
    public Optional<PhoneNumber> findByNumber(String number) {
        return Optional.ofNullable(store.get(number));
    }
}
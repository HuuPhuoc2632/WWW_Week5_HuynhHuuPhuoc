package com.example.www_week5_huynhhuuphuoc.backend.services;

import com.example.www_week5_huynhhuuphuoc.backend.models.Address;
import com.example.www_week5_huynhhuuphuoc.backend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Optional<Address> findById(long id ){
        return addressRepository.findById(id);
    }
}
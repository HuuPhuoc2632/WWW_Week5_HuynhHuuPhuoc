package com.example.www_week5_huynhhuuphuoc.repositories;

import com.example.www_week5_huynhhuuphuoc.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}

package com.example.www_week5_huynhhuuphuoc.repositories;

import com.example.www_week5_huynhhuuphuoc.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}

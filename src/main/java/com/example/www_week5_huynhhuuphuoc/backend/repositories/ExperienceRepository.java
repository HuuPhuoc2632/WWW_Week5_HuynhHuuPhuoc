package com.example.www_week5_huynhhuuphuoc.backend.repositories;

import com.example.www_week5_huynhhuuphuoc.backend.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}

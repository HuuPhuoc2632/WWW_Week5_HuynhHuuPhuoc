package com.example.www_week5_huynhhuuphuoc.backend.services;

import com.example.www_week5_huynhhuuphuoc.backend.models.Skill;
import com.example.www_week5_huynhhuuphuoc.backend.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> findAll(){
        return skillRepository.findAll();
    }

    public Skill getById(Long id){
        return skillRepository.getById(id);
    }

}
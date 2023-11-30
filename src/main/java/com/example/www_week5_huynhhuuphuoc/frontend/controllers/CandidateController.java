package com.example.www_week5_huynhhuuphuoc.frontend.controllers;

import com.example.www_week5_huynhhuuphuoc.backend.enums.SkillLevel;
import com.example.www_week5_huynhhuuphuoc.backend.models.Address;
import com.example.www_week5_huynhhuuphuoc.backend.models.Candidate;
import com.example.www_week5_huynhhuuphuoc.backend.models.CandidateSkill;
import com.example.www_week5_huynhhuuphuoc.backend.models.Skill;
import com.example.www_week5_huynhhuuphuoc.backend.repositories.CandidateRepository;
import com.example.www_week5_huynhhuuphuoc.backend.services.AddressService;
import com.example.www_week5_huynhhuuphuoc.backend.services.CandidateServices;
import com.example.www_week5_huynhhuuphuoc.backend.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {

    @Autowired
    private CandidateServices candidateServices;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private SkillService skillService;


    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateServices.findAll());
        return "candidates/candidates";
    }

    @GetMapping("/candidates")
    public String showCandidateListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage = candidateServices.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("candidatePage", candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/candidates-paging";
    }
    @GetMapping("/apply")
    public String applyCandidate(Model model){
        List<Address> addresses = addressService.findAll();
        List<Skill> skills = skillService.findAll();
        SkillLevel[] skillLevels = SkillLevel.values();
        model.addAttribute("skills", skills);
        model.addAttribute("skillLevels", skillLevels);
        model.addAttribute("addresses",addresses);

        model.addAttribute("candidate", new Candidate());
        model.addAttribute("candidate_Skill", new CandidateSkill());
        return "candidates/add-candidates";
    }


}
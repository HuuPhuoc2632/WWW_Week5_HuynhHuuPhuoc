package com.example.www_week5_huynhhuuphuoc.models;

import com.example.www_week5_huynhhuuphuoc.enums.SkillLevel;
import com.example.www_week5_huynhhuuphuoc.id.CandidateSkillID;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "candidate_skill")
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(CandidateSkillID.class)
public class CandidateSkill {
    @Column(name = "more_infos", length = 1000)
    private String moreInfos;
    @Column(name = "skill_level", length = 4)
    private SkillLevel skillLevel;

    @Id
    @OneToOne
    @JoinColumn(name = "can_id")
    private Candidate canId;

    @Id
    @OneToOne
    @JoinColumn(name = "skill_id")
    private Skill skillId;

}


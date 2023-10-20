package com.example.www_week5_huynhhuuphuoc.backend.models;


import com.example.www_week5_huynhhuuphuoc.backend.id.JobSkillID;
import com.example.www_week5_huynhhuuphuoc.backend.enums.SkillLevel;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "job_skill")
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(JobSkillID.class)
public class JobSkill {
    @Column(name = "more_infos", length = 1000)
    private String moreInfos;
    @Column(name = "skill_level", length = 4)
    private SkillLevel skillLevel;

    @Id
    @OneToOne
    @JoinColumn(name = "skill_id")
    private Skill skillId;

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job jobId;
}


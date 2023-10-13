package com.example.www_week5_huynhhuuphuoc.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "job")
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = {"id"})
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", length = 20)
    private long id;
    @Column(name = "job_name", length = 255)
    private String jobName;

    @ManyToOne
    @JoinColumn(name = "comp_id")
    private Company company;

    public Job(String jobName, Company company) {
        this.jobName = jobName;
        this.company = company;
    }
}

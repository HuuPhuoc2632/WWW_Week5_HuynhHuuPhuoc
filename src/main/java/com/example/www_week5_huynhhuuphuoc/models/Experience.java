package com.example.www_week5_huynhhuuphuoc.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "experience")
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String company;
    @Column(name = "from_date")
    private Date fromDate;
    @Column(length = 100)
    private String role;
    @Column(name = "to_date")
    private Date toDate;
    @Column(name = "work_desc", length = 400)
    private String workDesc;

    @OneToOne
    @JoinColumn(name = "id")
    private Candidate candidateId;

    public Experience(String company, Date fromDate, String role, Date toDate, String workDesc, Candidate candidateId) {
        this.company = company;
        this.fromDate = fromDate;
        this.role = role;
        this.toDate = toDate;
        this.workDesc = workDesc;
        this.candidateId = candidateId;
    }
}

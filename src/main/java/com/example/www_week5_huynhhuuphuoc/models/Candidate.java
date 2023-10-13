package com.example.www_week5_huynhhuuphuoc.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "candidate")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = {"id"})
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private long id;
    private Date dob;
    @Column(length = 255)
    private String email;
    @Column(name = "full_name", length = 255)
    private String fullName;
    @Column(length = 15)
    private String phone;

    @OneToMany
    @JoinColumn(name = "id")
    @Column(length = 20)
    private List<Address> address;

    public Candidate(Date dob, String email, String fullName, String phone, List<Address> address) {
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
    }
}

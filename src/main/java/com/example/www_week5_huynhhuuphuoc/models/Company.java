package com.example.www_week5_huynhhuuphuoc.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id", length = 20)
    private long id;
    @Column(length = 2000)
    private String about;
    @Column(length = 255)
    private String email;
    @Column(name = "comp_name", length = 255)
    private String compName;
    @Column(length = 255)
    private String phone;
    @Column(name = "web_url", length = 255)
    private String webUrl;

    @OneToOne
    @JoinColumn(name = "id")
    private Address address;

    public Company(String about, String email, String compName, String phone, String webUrl, Address address) {
        this.about = about;
        this.email = email;
        this.compName = compName;
        this.phone = phone;
        this.webUrl = webUrl;
        this.address = address;
    }
}

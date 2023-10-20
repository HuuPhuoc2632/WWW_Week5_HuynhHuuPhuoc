package com.example.www_week5_huynhhuuphuoc.backend.models;

import com.example.www_week5_huynhhuuphuoc.backend.enums.Country;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private long add_id;
    @Column(length = 150)
    private String street;
    @Column(length = 50)
    private String city;
    @Column(length = 6)
    private Country country;
    @Column(length = 20)
    private String number;
    @Column(name = "zipcode", length = 7)
    private String zipCode;

    public Address(String street, String city, Country country, String number, String zipCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.number = number;
        this.zipCode = zipCode;
    }
}

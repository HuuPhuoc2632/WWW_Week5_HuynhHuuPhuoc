    package com.example.www_week5_huynhhuuphuoc.backend.models;

    import jakarta.persistence.*;
    import lombok.*;

    import java.time.LocalDate;
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
        private LocalDate dob;
        @Column(length = 255)
        private String email;
        @Column(name = "full_name", length = 255)
        private String fullName;
        @Column(length = 15)
        private String phone;

        @OneToOne
        @JoinColumn(name = "address") // Đặt tên cột trong bảng Candidate để lưu khóa ngoại
        private Address address;

        public Candidate(String fullName, LocalDate dob, Address address, String phone, String email) {
            this.dob = dob;
            this.email = email;
            this.fullName = fullName;
            this.phone = phone;
            this.address = address;
        }
    }

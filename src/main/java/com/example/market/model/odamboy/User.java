package com.example.market.model.odamboy;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name = ("users"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = ("user_type_id"), insertable = false, updatable = false)
    private UserType userType;

    @Column(name = ("user_type_id"))
    private Integer userTypeId;

    @Column(name = ("username"), unique = true, nullable = false)
    private String username;

    @Column(name = ("password"))
    private String password;

    @Column(name = ("email"), unique = true)
    private String email;

    @Column(name = ("token"))
    private String token;

    @Column(name = ("first_name"))
    private String firstname;

    @Column(name = ("last_name"))
    private String lastname;

    @Column(name = ("avatar"))
    private String avatar;

    @Column(name = ("phone"), length = 45, unique = true)
    private String phone;

    @Column(name = ("birth"))
    private LocalDate birth;

    @Column(name = ("address"))
    private String address;

    @Column(name = ("address2"))
    private String address2;

    @Column(name = ("city_id"))
    private Integer cityId;

    @Column(name = ("postcode"))
    private String postcode;

    @Column(name = ("qr_code"))
    private String qrCode;

    @Column(name = ("email_verified_at"))
    private LocalDateTime emailVerifiedAt;

    @Column(name = ("phone_verified_at"))
    private LocalDateTime phoneVerifiedAt;

    @Column(name = ("status"))
    private Boolean status;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updatedAt"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;



}

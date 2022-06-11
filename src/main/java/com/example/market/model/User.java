package com.example.market.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("users"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = ("user_name"))
    private String userName;
    private String password;
    private String email;
    private String token;
    @Column(name = ("first_name"))
    private String firstName;
    @Column(name = ("last_name"))
    private String lastName;
    private String avatar;
    private String phone;
    private String address;
    private String address2;
    @Column(name = ("city_id"))
    private Integer cityId;
    @Column(name = ("post_code"))
    private String postCode;
    @Column(name = ("qr_code"))
    private String qrCode;
    private boolean status;


    private LocalDate birth;
    @Column(name = ("phone_verified_at"))
    private LocalDateTime phoneVerifiedAt;
    @Column(name = ("email_verified_at"))
    private LocalDateTime emailVerifiedAt;
    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = ("user_type"), insertable = false, updatable = false)
    private UserType userType;
    @Column(name = ("user_type_id"))
    private Integer userTypeId;


}

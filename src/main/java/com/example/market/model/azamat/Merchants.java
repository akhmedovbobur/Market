package com.example.market.model.azamat;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("merchants"))
public class Merchants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = ("user_id"))
    private Integer userId;
    private String slug;
    private String name;
    @Column(name = ("image_thumb"))
    private String imageThumb;
    @Column(name = ("is_featured"))
    private Boolean isFeatured;
    private String phone;
    private String mobile;
    private String email;
    private String website;
    private String address;
    private String country;
    private Boolean status;
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}

package com.example.market.model.hasanboy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("models"))
public class Models {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = ("name"))
    private String name;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = ("brands_id"),insertable = false,updatable = false)
    private Brands brands;
    @Column(name = ("brands_id"))
    private Integer brandId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}

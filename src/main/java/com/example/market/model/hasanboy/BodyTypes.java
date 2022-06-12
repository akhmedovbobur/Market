package com.example.market.model.hasanboy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("body_types"))
public class BodyTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean status;
    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}

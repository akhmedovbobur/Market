package com.example.market.model.asadbek;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("applicationsType"))
public class ApplicationsType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    @Column(name = ("display_name"))
    private String displayName;
    @Column(name = ("display_class"))
    private String displayClass;
    @Column(name = ("display_icon"))
    private String displayIcon;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
}

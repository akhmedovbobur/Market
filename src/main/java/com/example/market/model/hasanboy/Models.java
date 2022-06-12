package com.example.market.model.hasanboy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = ("models"))
public class Models {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand_id;
    private String name;
    private Boolean status;

}

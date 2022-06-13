package com.example.market.model.azamat;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = ("vehicles"))
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = ("merchant_id"))
    private Integer merchantId;

    @Column(name = ("brand_id"))
    private Integer branId;

    @Column(name = ("model_id"))
    private Integer modelId;

    @Column(name = ("body_type_id"))
    private Integer bodyTypeId;

    private String name;
    private Integer year;
    private String color;
    private Double price;

    @Column(name = ("number_sits"))
    private Integer numberSits;

    @Column(name = ("is_new"))
    private Boolean isNew;
    private Boolean status;

    @Column(name = ("condition_duration_type"))
    private Integer conditionDurationType;

    @Column(name = ("condition_duration"))
    private Integer condition_duration;

    @Column(name = ("condition_price"))
    private Double conditionPrice;
}

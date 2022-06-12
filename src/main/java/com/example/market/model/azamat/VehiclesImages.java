package com.example.market.model.azamat;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = ("vehicles_images"))
public class VehiclesImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = ("vehicle_id"))
    private Integer vehicleId;

    @Column(name = ("image_id"))
    private Integer imageId;
}

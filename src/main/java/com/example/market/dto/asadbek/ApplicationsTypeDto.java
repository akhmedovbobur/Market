package com.example.market.dto.asadbek;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ApplicationsTypeDto {

    private Integer id;
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "display_class")
    private String displayClass;
    @Column(name = "display_icon")
    private String displayIcon;

}

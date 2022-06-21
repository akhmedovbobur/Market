package com.example.market.dto.azamat;

import com.example.market.model.azamat.Merchants;
import com.example.market.model.hasanboy.Brands;
import com.example.market.model.hasanboy.Models;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehiclesDto {
    private Integer id;

    private Merchants merchants;
    @NotNull(message = ("The merchantsId cannot be empty or null"))
    private Integer merchantsId;

    private Brands brands;
    @NotNull(message = ("The brandId cannot be empty or null"))
    private Integer brandId;

    private Models models;
    @NotNull(message = ("The modelsId cannot be empty or null"))
    private Integer modelsId;
}

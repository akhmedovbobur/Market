package com.example.market.dto.azamat;

import com.example.market.model.azamat.Vehicles;
import com.example.market.model.azamat.VehiclesImages;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehiclesImagesDto {

    private Integer id;

    private Vehicles vehicles;
    @NotNull(message = ("The vehicles cannot be empty or null"))
    private Integer vehiclesId;

    @NotBlank(message = ("The url cannot be empty or null"))
    private String url;

    @NotNull(message = ("The position cannot be empty or null"))
    private Integer position;

    @NotNull
    private Boolean isDefault;
    @NotNull
    private Boolean status;
}

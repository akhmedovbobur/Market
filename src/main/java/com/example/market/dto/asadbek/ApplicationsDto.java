package com.example.market.dto.asadbek;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class ApplicationsDto {

    private Integer id;
    @NotBlank(message = ("The typeId cannot be empty or null"))
    private Integer typeId;
    @NotBlank(message = ("The userId cannot be empty or null"))
    private  Integer userId;
    @NotBlank(message = ("The merchantId cannot be empty or null"))
    private Integer merchantId;
    @NotBlank(message = ("The vehicleId cannot be empty or null"))
    private Integer vehicleId;
    @NotBlank(message = ("The vehicleDetails cannot be empty or null"))
    private String vehicleDetails;
    private Double price;
    @NotBlank(message = ("The conditionPrice cannot be empty or null"))
    private Double conditionPrice;
    @NotBlank(message = ("The conditionDurationType cannot be empty or null"))
    private Integer conditionDurationType;
    @NotBlank(message = ("The conditionDuration cannot be empty or null"))
    private Integer conditionDuration;
    @NotBlank(message = ("The prosesStatusId cannot be empty or null"))
    private Integer prosesStatusId;

}

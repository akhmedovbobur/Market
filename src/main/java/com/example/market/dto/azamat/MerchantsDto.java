package com.example.market.dto.azamat;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MerchantsDto {
    private Integer id;

    @NotBlank(message = ("The slug cannot be empty or null"))
    private String slug;
    @NotBlank(message = ("The name cannot be empty or null"))
    private String name;
    @NotBlank(message = ("The image_thumb cannot be empty or null"))
    private String imageThumb;
    @NotBlank(message = ("The is_featured cannot be empty or null"))
    private String isFeatured;
    @NotBlank(message = ("The phone cannot be empty or null"))
    private String phone;
    @NotBlank(message = ("The mobile cannot be empty or null"))
    private String mobile;
    @NotBlank(message = ("The email cannot be empty or null"))
    private String email;
    @NotBlank(message = ("The website cannot be empty or null"))
    private String website;
    @NotBlank(message = ("The address cannot be empty or null"))
    private String address;
    @NotBlank(message = ("The country cannot be empty or null"))
    private String country;
}

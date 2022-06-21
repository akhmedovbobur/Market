package com.example.market.dto.odamboy;


import com.example.market.model.odamboy.UserType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;

    private UserTypeDto userTypeDto;
    private Integer userTYpeId;


    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Email
    private String email;

    private String token;
    private String firstname;
    private String lastname;
    private String avatar;

    @NotBlank
    private String phone;

    private LocalDate birth;
    private String address;
    private String address2;
    private Integer cityId;
    private String postcode;
    private String qrCode;
    private LocalDateTime emailVerifiedAt;
    private LocalDateTime phoneVerifiedAt;
    private Boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}

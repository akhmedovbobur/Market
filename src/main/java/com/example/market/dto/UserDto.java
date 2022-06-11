package com.example.market.dto;


import com.example.market.model.UserType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Integer id;
    @NotBlank(message = ("The Username cannot be empty or null"))
    private String userName;
    @NotBlank(message = ("The Password cannot be empty or null"))
    private String password;
    @NotBlank(message = ("The email cannot be empty or null"))
    private String email;
    @NotBlank(message = ("The token cannot be empty or null"))
    private String token;
    @NotBlank(message = ("The firstName cannot be empty or null"))
    private String firstName;
    @NotBlank(message = ("The lastname cannot be empty or null"))
    private String lastName;
    @NotBlank(message = ("The avatar cannot be empty or null"))
    private String avatar;
    @NotBlank(message = ("The phone cannot be empty or null"))
    private String phone;
    @NotBlank(message = ("The address cannot be empty or null"))
    private String address;
    @NotBlank(message = ("The address2 cannot be empty or null"))
    private String address2;
    @NotBlank(message = ("The address2 cannot be empty or null"))
    private Integer cityId;
    @NotBlank(message = ("The postCode cannot be empty or null"))
    private String postCode;
    @NotBlank(message = ("The qr_code cannot be empty or null"))
    private String qrCode;
    private boolean status;

    @NotBlank(message = ("The qr_code cannot be empty or null"))
    private LocalDate birth;
    @NotBlank(message = ("The phoneVerifiedAt cannot be empty or null"))
    private LocalDateTime phoneVerifiedAt;
    @NotBlank(message = ("The emailVerifiedAt cannot be empty or null"))
    private LocalDateTime emailVerifiedAt;

    private UserType userType;
    @NotNull(message = ("The user type cannot be empty or null"))
    private Integer userTypeId;




}

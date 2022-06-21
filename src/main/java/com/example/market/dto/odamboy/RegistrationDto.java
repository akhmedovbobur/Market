package com.example.market.dto.odamboy;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RegistrationDto {
    @NotEmpty(message = "Please provide a firstname")
    private String firstname;
    @NotBlank(message = "Please provide a lastname")
    private String lastname;
    @Email(message = "Please provide email")
    private String email;
    @NotBlank(message = "Please provide username")
    private String username;
    @NotBlank(message = "Please provide a  password")
    @Size(min = 8, message = ("Password must be less than 8 length"))
    private String password;
}

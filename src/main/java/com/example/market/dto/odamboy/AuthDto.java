package com.example.market.dto.odamboy;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthDto {
    @NotBlank(message = ("Username Error"))
    private String username;
    @NotBlank(message = ("Password Error"))
    @Size(min = 8, message = ("Password must be less than 8 length"))
    private String password;
}

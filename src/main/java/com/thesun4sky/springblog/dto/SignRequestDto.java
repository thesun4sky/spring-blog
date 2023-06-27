package com.thesun4sky.springblog.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignRequestDto {
    @Pattern(regexp = "^[a-z0-9]{4,10}$")
    private String username;

    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9]{8,15}$")
    private String password;
}

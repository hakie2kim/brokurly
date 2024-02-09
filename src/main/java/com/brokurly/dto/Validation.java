package com.brokurly.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class Validation {
    @Min(10)
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
    @Email
    @NotNull
    private String email;
}

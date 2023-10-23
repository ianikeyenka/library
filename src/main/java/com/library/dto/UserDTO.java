package com.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;

    @NotBlank(message = "not be empty")
    @Size(min = 1, max = 15, message = "name must be between 1 and 15 symbols")
    private String name;

    @NotBlank(message = "not be empty")
    @Size(min = 1, max = 30, message = "name must be between 1 and 30 symbols")
    private String surname;

    @Pattern(regexp = "^\\+375-\\d{2}-\\d{3}-\\d{4}$", message = "phone number must be +375-##-###-####")
    private String phone;
}

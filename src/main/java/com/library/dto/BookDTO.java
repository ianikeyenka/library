package com.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDTO {
    private Long id;

    @NotBlank(message = "not be empty")
    @Size(min = 1, max = 60, message = "title must be between 1 and 60 symbols")
    private String title;

    @NotBlank(message = "not be empty")
    @Size(min = 1, max = 30, message = "title must be between 1 and 30 symbols")
    private String author;
}

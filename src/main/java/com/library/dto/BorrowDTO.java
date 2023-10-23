package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BorrowDTO {
    private Long id;
    private UserDTO user;
    private BookDTO book;
    private boolean returned;
}

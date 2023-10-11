package com.library.mapper;

import com.library.dto.UserDTO;
import com.library.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO userToUserDto(User user);

    User userDtoToUser(UserDTO userDTO);
}

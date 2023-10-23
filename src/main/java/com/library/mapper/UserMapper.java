package com.library.mapper;

import com.library.dto.UserDTO;
import com.library.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO userToUserDto(UserEntity user);

    UserEntity userDtoToUser(UserDTO userDTO);
}

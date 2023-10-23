package com.library.service.impl;

import com.library.dto.UserDTO;
import com.library.entity.BorrowEntity;
import com.library.entity.UserEntity;
import com.library.exception.ResourceNotFoundException;
import com.library.mapper.UserMapper;
import com.library.repository.BorrowRepository;
import com.library.repository.UserRepository;
import com.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BorrowRepository borrowRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public List<UserDTO> getUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDTO getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id - " + id + " not found"));
        return userMapper.userToUserDto(user);
    }

    @Override
    @Transactional
    public List<UserDTO> getUsersBorrowedBook(Long id) {
        List<BorrowEntity> borrows = borrowRepository.findAllByBookId(id);
        return borrows.stream()
                .map(borrow -> userMapper.userToUserDto(borrow.getUser()))
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        userRepository.save(userMapper.userDtoToUser(userDTO));
    }
}

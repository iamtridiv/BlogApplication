package com.xofuratech.BlogApplication.services.impl;

import com.xofuratech.BlogApplication.entities.User;
import com.xofuratech.BlogApplication.exceptions.ResourceNotFoundException;
import com.xofuratech.BlogApplication.payloads.UserDto;
import com.xofuratech.BlogApplication.repositories.UserRepo;
import com.xofuratech.BlogApplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User savedUser = userRepo.save(userDtoToUser(userDto));
        return userToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = userRepo.save(user);
        return userToUserDto(updatedUser);
    }

    @Override
    public UserDto getUserById(int userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return userToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(this::userToUserDto).toList();
    }

    @Override
    public void deleteUser(int userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepo.delete(user);
    }

    public User userDtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
    private UserDto userToUserDto(User savedUser) {
        /*
        UserDto userDto = new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setName(savedUser.getName());
        userDto.setEmail(savedUser.getEmail());
        userDto.setPassword(savedUser.getPassword());
        userDto.setAbout(savedUser.getAbout());
         */
        return modelMapper.map(savedUser, UserDto.class);
    }
}

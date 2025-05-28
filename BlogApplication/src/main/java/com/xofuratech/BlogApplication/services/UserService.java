package com.xofuratech.BlogApplication.services;

import com.xofuratech.BlogApplication.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, int userId);
    UserDto getUserById(int userId);
    List<UserDto> getAllUsers();
    void deleteUser(int userId);
}

package main.java.com.example.demo.service;

import main.java.com.example.demo.dto.UserDto;

import java.util.List;

/**
 * Created by ikovacic
 */
public interface IUserService {
    UserDto getUserById(Integer userId);
    void saveUser(UserDto userDto);
    List<UserDto> getAllUsers();
}

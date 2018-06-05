package main.java.com.example.demo.service;

import main.java.com.example.demo.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by ikovacic
 */
public interface IUserService {
    ResponseEntity<UserDto> getUserByEmail(String email);

    ResponseEntity<UserDto> getUserById(Long userId);

    ResponseEntity saveUser(UserDto userDto);

    ResponseEntity<UserDto> updateUser(UserDto userDto);

    ResponseEntity<UserDto> updateUser(Long userId, UserDto userDto);

    List<UserDto> getAllUsers();

    ResponseEntity deleteUser(UserDto userDto);
}

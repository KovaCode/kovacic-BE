package main.java.com.example.demo.service.impl;

import main.java.com.example.demo.converter.UserConverter;
import main.java.com.example.demo.dto.UserDto;
import main.java.com.example.demo.entity.User;
import main.java.com.example.demo.repository.UserRepository;
import main.java.com.example.demo.service.IUserService;
import main.java.com.example.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ikovacic.
 */
@Service
public class UserServiceimpl implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<UserDto> getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return new ResponseEntity<>(UserConverter.entityToDto(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> getUserById(Long userId) {
        User user = userRepository.findOne(userId);
        return new ResponseEntity<>(UserConverter.entityToDto(user), HttpStatus.OK);
    }



    @Override
    public ResponseEntity saveUser(UserDto userDto) {
        userRepository.save(UserConverter.dtoToEntity(userDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }

    @Override
    public @ResponseBody ResponseEntity<UserDto> updateUser(Long userId, UserDto userDto) {

        User user = UserConverter.dtoToEntity(this.getUserById(userId).getBody());
        User userUp = UserConverter.dtoToEntity(userDto);
        Utils.copyNonNullProperties(user, userUp);
        userRepository.save(userUp);
        return new ResponseEntity<>(UserConverter.entityToDto(userUp), HttpStatus.ACCEPTED);
    }


    @Override
    public @ResponseBody ResponseEntity<UserDto> updateUser(UserDto userDto) {
        User user = userRepository.save(UserConverter.dtoToEntity(userDto));
        return new ResponseEntity<>(UserConverter.entityToDto(user), HttpStatus.ACCEPTED);
    }


    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity deleteUser(UserDto userDto) {
        userRepository.delete(UserConverter.dtoToEntity(userDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


}

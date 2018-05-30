package main.java.com.example.demo.service.impl;

import main.java.com.example.demo.converter.UserConverter;
import main.java.com.example.demo.dto.UserDto;
import main.java.com.example.demo.repository.UserRepository;
import main.java.com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ashish on 13/5/17.
 */
@Service
public class UserServiceimpl implements IUserService {
	@Autowired
    UserRepository userRepository;

	@Override
	public UserDto getUserById(Integer userId) {
		return UserConverter.entityToDto(userRepository.findOne(userId));
	}

	@Override
	public void saveUser(UserDto userDto) {
		userRepository.save(UserConverter.dtoToEntity(userDto));
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
	}
}

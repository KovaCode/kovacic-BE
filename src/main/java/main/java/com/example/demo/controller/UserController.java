package main.java.com.example.demo.controller;

import main.java.com.example.demo.dto.UserDto;
import main.java.com.example.demo.service.IUserService;
import main.java.com.example.demo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 * Created by ashish on 13/5/17.
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	IUserService userService;

	@RequestMapping(Constants.GET_USER_BY_ID)
	public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}

	@RequestMapping(Constants.GET_ALL_USERS)
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}

	@PutMapping(Constants.UPDATE_USER)
	public ResponseEntity<UserDto> updateUser(@PathVariable(value = "id") Long userId,
						   @Valid @RequestBody UserDto userDto) {
		return userService.updateUser(userId, userDto);
	}

	@PostMapping(value= Constants.SAVE_USER)
	public ResponseEntity saveUser(@RequestBody UserDto userDto) {
		return userService.saveUser(userDto);
	}

	@DeleteMapping(value= Constants.DELETE_USER)
	public ResponseEntity deleteUser(@RequestBody UserDto userDto) {
		return userService.deleteUser(userDto);
	}




}

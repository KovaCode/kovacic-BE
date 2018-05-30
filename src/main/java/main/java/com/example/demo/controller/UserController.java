package main.java.com.example.demo.controller;

import main.java.com.example.demo.dto.UserDto;
import main.java.com.example.demo.service.IUserService;
import main.java.com.example.demo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public UserDto getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}
	
	@RequestMapping(Constants.GET_ALL_USERS)
	public List<UserDto> getAllUsers() {

		return userService.getAllUsers();
	}
	
	@RequestMapping(value= Constants.SAVE_USER, method= RequestMethod.POST)
	public void saveUser(@RequestBody UserDto userDto) {
		userService.saveUser(userDto);
	}
}

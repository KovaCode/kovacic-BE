package main.java.com.example.demo.converter;

import main.java.com.example.demo.dto.UserDto;
import main.java.com.example.demo.entity.User;

/**
 * Created by ashish on 13/5/17.
 */
public class UserConverter {
	public static User dtoToEntity(UserDto userDto) {
		User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getUserName(),userDto.getPassword(), null);
		user.setID(userDto.getID());
//		user.setSkills(userDto.get().stream().map(SkillConverter::dtoToEntity).collect(Collectors.toList()));
		return user;
	}

	public static UserDto entityToDto(User user) {
		UserDto userDto = new UserDto(user.getID(), user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword());
//		userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return userDto;
	}
}

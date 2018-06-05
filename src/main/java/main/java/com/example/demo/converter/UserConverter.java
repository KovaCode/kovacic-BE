package main.java.com.example.demo.converter;

import main.java.com.example.demo.dto.UserDto;
import main.java.com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ikovaci.
 */
public class UserConverter {
    public static User dtoToEntity(UserDto userDto) {
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getUserName(), userDto.getPassword(), userDto.getEmail(), SkillConverter.dtoToEntityList(userDto.getSkillDtos()), userDto.getNote());
        user.setID(userDto.getID());
        return user;
    }

    public static UserDto entityToDto(User user) {
        UserDto userDto = new UserDto(user.getID(), user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(), user.getEmail(), SkillConverter.entityToDtoList(user.getSkills()), user.getNote());
        return userDto;
    }

    public static List<UserDto> listEntityToDto(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : users) {
            UserDto userDto = new UserDto(user.getID(), user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(), user.getEmail());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

}

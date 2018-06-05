package com.kovacic.be;

import com.kovacic.be.dto.SkillDto;
import com.kovacic.be.dto.UserDto;
import com.kovacic.be.service.ISkillService;
import com.kovacic.be.service.IUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class UserTest extends AbstractTestNGSpringContextTests {
    private final String skillName = "Hibernate";
    private final String skillNameUpdate = "Java/Hibernate/JPA";

    @Autowired
    private IUserService userService;

    @Autowired
    private ISkillService skillService;



    @Test
    public void testCreateUser(){

        skillService.saveSkill(new SkillDto("Testing"));

        List<SkillDto> listSkills = skillService.getSkills().getBody();

        UserDto user = new UserDto();
        user.setFirstName("Testing");
        user.setLastName("Tester");
        user.setUserName("Test101");
        user.setPassword("Test@101.");
        user.setEmail("test@tester.com");
        user.setNote("notifications");
        user.setSkillDtos(listSkills);

        System.err.println(user);
        System.err.println(user.getSkillDtos());



        ResponseEntity<UserDto> response =  userService.saveUser(user);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);

    }




}

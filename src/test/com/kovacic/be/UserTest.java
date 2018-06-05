package com.kovacic.be;

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


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class UserTest extends AbstractTestNGSpringContextTests {

    private String skillName = "Automation Testing";
    private String email = "test@tester.com";

    @Autowired
    private IUserService userService;

    @Autowired
    private ISkillService skillService;


//    @BeforeClass
//    public void testSetup(){
//        skillService.saveSkill(new SkillDto(skillName)).getBody();
//    }
//
//    @AfterClass
//    public void testTearDown(){
//        skillService.deleteSkill(skillService.getSkillByName(skillName).getBody());
//    }


    @Test(priority = 10)
    public void testCreateUser() {
//        SkillDto skillDto = skillService.getSkillByName(skillName).getBody();

        UserDto user = new UserDto();
        user.setFirstName("Testing");
        user.setLastName("Tester");
        user.setUserName("Test101");
        user.setPassword("Test@101.");
        user.setEmail(email);
        user.setNote("notifications");
        user.setSkillDtos(skillService.getSkills().getBody());

        ResponseEntity<UserDto> response = userService.saveUser(user);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);

    }

    @Test(priority = 20)
    public void testDeleteUser() {
        UserDto userDto = userService.getUserByEmail(email).getBody();
        ResponseEntity<UserDto> response = userService.deleteUser(userDto);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);
    }




}

package main.java.com.example.demo;

import main.java.com.example.demo.repository.UserRepository;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.Test;

import java.util.Collections;

/**
 * Created by ikovacic.
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class UnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @Test
    public void contextLoad() throws Exception {

        Mockito.when(userRepository.findAll()).thenReturn(Collections.emptyList());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        System.err.println(mvcResult.getResponse());

        Mockito.verify(userRepository.findAll());




    }
//
//    @Test
//    public void createUser() throws Exception {
////        UserDto user = new UserDto();
////        user.setEmail("ivan@ivan.com");
////        user.setPassword("test");
////        user.setFirstName("Marc");
////        user.setLastName("Mark");
////        user.setNote("This is just an exmaple not for testing");
//////        user.setSkillDtos(skillController.getAllSkils());
////
////        ResponseEntity<UserDto> response = userController.saveUser(user);
////        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
////
////        System.err.println("tests");
//    }





}

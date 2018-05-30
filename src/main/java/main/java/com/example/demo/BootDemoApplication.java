package main.java.com.example.demo;

import main.java.com.example.demo.entity.Skill;
import main.java.com.example.demo.entity.User;
import main.java.com.example.demo.repository.SkillRepository;
import main.java.com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class BootDemoApplication {

	@Autowired
    UserRepository userRepository;
    @Autowired
    SkillRepository skillRepository;


	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

	@PostConstruct
	public void setupDbWithData(){

        ArrayList<Skill> list = new ArrayList<>(Arrays.asList(new Skill("Java"), new Skill("Selenium"), new Skill("Hibernate")));

		User user = new User("Ivan", "Kovacic", "ikovacic", DigestUtils.md5Digest("test123".getBytes()).toString());
        User user2 = new User("John", "Smithy", "smith", DigestUtils.md5Digest("123test".getBytes()).toString());


        for (Skill skill :list) {
            skillRepository.save(skill);
        }

		user= userRepository.save(user);
        user= userRepository.save(user2);



	}
}

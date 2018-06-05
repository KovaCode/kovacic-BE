package main.java.com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by ikovacic.
 */
@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
}

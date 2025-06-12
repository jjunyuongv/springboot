package com.edu.springboot.bean2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Di2Controller
{
	@Autowired
	Student student;
	
	@Autowired
	@Qualifier("macBook")
	Computer computer;
	
	@RequestMapping("/di2")
	@ResponseBody
	public String home() {
		System.out.println(student);
		return "Dependency Injection2 (의존주입2)";
	}
}

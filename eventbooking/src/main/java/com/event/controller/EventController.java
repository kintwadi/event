package com.event.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventController {

	@RequestMapping("/")
	public String initializer(){
		return "main";
	}

}

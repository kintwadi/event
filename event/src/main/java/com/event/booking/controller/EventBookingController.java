package com.event.booking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.event.booking.model.User;
import com.event.booking.response.Response;
import com.event.booking.service.EventBookingService;

@Controller
@RequestMapping("/")
public class EventBookingController {
	
	@Autowired
	private EventBookingService service;

	@RequestMapping("/")
	public String initializer(HttpServletRequest request,HttpSession session ) {

		return service.getInitPage().getView();
	}
	
	/**
	 * é apenas um teste
	 * @return
	 */
	@RequestMapping("user")
	public String addUser() {
		User user = new User();
		user.setUserName("pedro");
		user.setPassword("2222");
		user.setEmail("pedro4@gmail.com");
		Response response = service.addUser(user); 
		System.out.println(response.getResponseData().toString());
		return response.getView();
	}

	

}

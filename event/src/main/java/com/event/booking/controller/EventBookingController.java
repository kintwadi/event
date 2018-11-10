package com.event.booking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.event.booking.model.User;
import com.event.booking.response.Response;
import com.event.booking.service.EventBookingService;

@Controller
@RequestMapping("/")
public class EventBookingController {
	
	@Autowired
	private EventBookingService service;
	@Autowired
	private User user;

	@RequestMapping("/")
	public String initializer( Model model,HttpSession session) {

		return service.getInitPage().getView();
	}
	
	/**
	 * é apenas um teste 
	 * @return
	 */
	@RequestMapping("/login")
	public String addUser(HttpServletRequest request, Model model,HttpSession session) {
		
		service.extractParrams(user, request);
		Response response = service.addUser(user); 
		model.addAttribute("msg", response.getMessage());
		System.out.println(response.getMessage());
		return response.getView();
	}
	
	@RequestMapping("/getUsers")
	@ResponseBody
	public List <Object>getUsers(HttpServletRequest request, Model model,HttpSession session) {
		
		Response users = service.getUsers(user);
		users.getReponseDataList().forEach(System.out::println);
		return users.getReponseDataList();
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public List <Object>getUser(@RequestParam("userName") String userName) {
		
		Response users = service.getUser(user, userName, userName);
		users.getReponseDataList().forEach(System.out::println);
		return users.getReponseDataList();
	}
	
	
	

	

}

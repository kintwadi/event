package com.event.booking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.event.booking.model.Comment;
import com.event.booking.model.Event;
import com.event.booking.model.JoinEvent;
import com.event.booking.model.JoinEventHelper;
import com.event.booking.model.Placement;
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
	@Autowired
	private Event event;
	@Autowired
	private Placement placement;
	@Autowired
	private JoinEventHelper joinEventHelper;

	@Autowired
	private Comment comment;

	@RequestMapping("/")
	public String initializer( @ModelAttribute User user,Model model,HttpSession session) {


		return service.getInitPage().getView();
	}

	// Users
	@PostMapping("/register_user")
	public String registerUser(@RequestBody User user, Model model) {

		Response response = service.addUser(user); 
		model.addAttribute("msg", response.getMessage());
		return response.getView();
	}
	
	@PostMapping("/update_user")
	public String updateUser(@RequestBody User user,Model model) {

		Response response = service.updateUser(user);
		model.addAttribute("msg", response.getMessage());
		return response.getView();
	}
	@PostMapping("/remove_user")
	public String removeUser(@RequestBody User user,Model model) {

		Response response = service.removeUser(user);
		model.addAttribute("msg", response.getMessage());
		return response.getView();
	}

	@GetMapping("/get_users")
	@ResponseBody
	public List <Object>getUsers(HttpSession session ) {

	
		return service.getUsers(user).getReponseDataList();
	}


	@GetMapping("/getUser_by_id/{id}")
	@ResponseBody
	public User getUserById(@PathVariable long id) {

		return (User)service.getUser(user, id).getResponseData();
	}

	@GetMapping("/get_user/{email:.+}")// allow .com extension on email
	@ResponseBody
	public User getUserByEmail(@PathVariable String email) {

		Response response = service.getElementByFieldName("User", "email", email);
		System.out.println(response.getResponseData().toString());
		
		return (User)service.getElementByFieldName("User", "email", email).getResponseData();
	}

	//EventsJoinEvent
	@PostMapping("/register_event/{eventOwnerEmail:.+}")
	@ResponseBody
	public String registerEvent(@RequestBody Event event,@PathVariable("eventOwnerEmail")String eventOwnerEmail, Model model) {

		System.out.println("eventOwnerEmail: "+ eventOwnerEmail);
		System.out.println("event: "+event.toString());
		user.setEmail(eventOwnerEmail);
		Response response = service.addEvent(user,event);
		return response.getStatus();
	}
	@PostMapping("/update_event")
	public String updateEvent(@RequestBody Event event, Model model) {

		Response response = service.addUser(user); 
		model.addAttribute("msg", response.getStatus());
		return response.getView();
	}

	@PostMapping("/delete_event")
	public String deleteEvent(@RequestBody Event event, Model model) {

		Response response = service.addUser(user); 
		model.addAttribute("msg", response.getStatus());
		return response.getView();
	}
	
	@PostMapping("/join_event/{eventId}/{userId}/{placementId}")
	@ResponseBody
	public String joinEvent(@RequestBody JoinEvent joinEvent,@PathVariable long eventId,@PathVariable long userId,@PathVariable long placementId) {
		
		
		user = (User)service.getById(user, userId);
		event = (Event)service.getById(event, eventId);
		placement = (Placement)service.getById(placement,placementId);
		
		joinEventHelper.setEventId(eventId);
		joinEventHelper.setUserId(userId);
		joinEventHelper.setPlacementId(placementId);

		joinEvent.addRelationShip(user).addRelationShip(event);	
		Response response = service.joinEvent(joinEvent);
		
		return response.getMessage();
	}
	
	@PostMapping("/book_event/{eventId}/{userId}/{placementId}")
	@ResponseBody
	public String bookEvent(@RequestBody JoinEvent joinEvent,@PathVariable long eventId,@PathVariable long userId,@PathVariable long placementId) {
		
		
		user = (User)service.getById(user, userId);
		event = (Event)service.getById(event, eventId);
		placement = (Placement)service.getById(placement,placementId);
		
		joinEventHelper.setEventId(eventId);
		joinEventHelper.setUserId(userId);
		joinEventHelper.setPlacementId(placementId);
		
		joinEvent.addRelationShip(user).addRelationShip(event);		
		Response response = service.bookEvent(joinEvent);
		
		return response.getMessage();
	}
	
	@RequestMapping("/gethome")
	public String goHome() {
		
		return "home";
	}








}
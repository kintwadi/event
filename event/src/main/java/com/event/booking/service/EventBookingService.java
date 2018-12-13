package com.event.booking.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.event.booking.dao.IEventBookingDao;
import com.event.booking.model.Event;
import com.event.booking.model.User;
import com.event.booking.response.Response;
import com.event.booking.response.Validator;

@Configuration
@ComponentScan(basePackages = { "com.event.booking.*" })
@PropertySources({
	@PropertySource("classpath:config.properties"),
	//@PropertySource("classpath:db.properties")
})
@Service
@Transactional
public class EventBookingService {
	@Autowired
	private IEventBookingDao dao;
	@Autowired
	Response response;
	@Autowired
	private Environment env;

	public Response addUser(User user) {


		if(!Validator.emailValidation(user.getEmail())) {

			response.setStatus(getMessage("user.add.error")+ user.getClass());
			response.setMessage(getMessage("user.email.erro"));
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setLogger(user.getClass().getName(), response.getMessage(), "severe");
			response.setView("login");
			return response;	
		}

		try {

			dao.add(user);
			response.setStatus(getMessage("user.update.success")+ user.getClass());
			response.setMessage("operation success ");
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setView("login");
			response.setResponseData(user);
			return response;

		} catch (Response ex) {

			response.setStatus(getMessage("user.update.error")+ user.getClass());
			response.setMessage(ex.getLocalizedMessage());
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setLogger(user.getClass().getName(), response.getMessage(), "severe");
		}

		return response;
	}
	public Response updateUser(User user) {

		if(!Validator.emailValidation(user.getEmail())) {

			response.setStatus(getMessage("user.update.error")+ user.getClass());
			response.setMessage(getMessage("user.email.error"));
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setLogger(user.getClass().getName(), response.getMessage(), "severe");
			response.setView("login");
			return response;	
		}

		try {

			dao.add(user);
			response.setStatus(getMessage("user.update.success")+ user.getClass());
			response.setMessage("operation success ");
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setView("login");
			response.setResponseData(user);
			return response;

		} catch (Response ex) {

			response.setStatus(getMessage("user.update.error")+ user.getClass());
			response.setMessage(ex.getLocalizedMessage());
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setLogger(user.getClass().getName(), response.getMessage(), "severe");
		}

		return response;
	}
	
	public Response removeUser(User user) {


		if(!Validator.emailValidation(user.getEmail())) {

			response.setStatus(getMessage("user.remove.error")+ user.getClass());
			response.setMessage(getMessage("user.email.erro"));
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setLogger(user.getClass().getName(), response.getMessage(), "severe");
			response.setView("login");
			return response;	
		}

		try {

			dao.add(user);
			response.setStatus(getMessage("user.remove.success")+ user.getClass());
			response.setMessage("operation success ");
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setView("login");
			response.setResponseData(user);
			return response;

		} catch (Response ex) {

			response.setStatus(getMessage("user.remove.error")+ user.getClass());
			response.setMessage(ex.getLocalizedMessage());
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setLogger(user.getClass().getName(), response.getMessage(), "severe");
		}

		return response;
	}

	private String getMessage(String key) {

		return  env.getProperty(key);	
	}

	public Response getUsers(User user){
		
		
		List<Object> users = dao.getAll(user);
		response.setReponseDataList(users);
		response.setMessage("list of users");
		return response;	
	}
	public Response getUser(User user,long id){
		user = (User) dao.getById(user, id);
		response.setResponseData(user);
		response.setMessage("single  user");
		return response;	
	}

	public Response getInitPage() {
		Response response = new Response();
		response.setView("login");
		return response;	
	}

	public void extractParrams(Object obj,HttpServletRequest request) {

		if(obj instanceof User) {

			((User) obj).setUserName(request.getParameter("userName"));
			((User) obj).setEmail(request.getParameter("email"));
			((User) obj).setPassword(request.getParameter("password"));	
		}

	}
	
	public Response addEvent(User user,Event event) {
		

		if(!userExist(user,user.getEmail())) {
			
			
			response.setStatus("user for this event  does not exist");
			return response;
		}
		try {
			
			user = (User) dao.getByEmail(user, user.getEmail());
			
			List<Event> events = new ArrayList<>();
			
			LocalDateTime currentTime = LocalDateTime.now();
			Month month = currentTime.getMonth();
		    int day = currentTime.getDayOfMonth();
		    int hour =currentTime.getHour();
		    int minuts = currentTime.getMinute();
		    int seconds = currentTime.getSecond();
		    Date date = Date.from(currentTime.toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
		    
			event.setDate(date);
			event.setDay(String.valueOf(day));
			event.setMonth(month.name());
			event.setHour(String.valueOf(hour));
			event.setMinuts(String.valueOf(minuts));
			event.setSeconds(String.valueOf(seconds));
			
			events.add(event);
			
			user.setEvents(events);
			
			event.setUser(user);
			
			dao.add(event);	
			
			response.setStatus("event added");
			
		} catch (Response e) {
		
			e.printStackTrace();
		}
		return response;
	}
	
	public Response updateEvent(Event event) {
		dao.update(event);
		response.setStatus("event updated");
		return response;
	}
	
	public Response deleteEvent(Event event) {
		dao.remove(event);
		response.setStatus("event added");
		return response;
	}
	
	public Response getElementByFieldName(String className,String field, String value) {
		
		response.setResponseData(dao.getElementByFieldName(className, field, value));
		response.setStatus("success");
		return response;
		
	}
	
	
	private boolean userExist(User user, String eventOwnerEmail) {
		
		user = (User)dao.getByEmail(user, eventOwnerEmail);
	
		return user != null ? true : false;
	}
	
	
	




}
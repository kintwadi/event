package com.event.booking.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
			
			response.setStatus(getMessage("userAdd.error")+ user.getClass());
			response.setMessage(getMessage("email.error"));
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setLogger(user.getClass().getName(), response.getMessage(), "severe");
			response.setView("login");
			return response;	
		}
		
		try {
			
			dao.add(user);
			response.setStatus(getMessage("user.add.success")+ user.getClass());
			response.setMessage("operation success ");
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setView("login");
			response.setResponseData(user);
			return response;
			
		} catch (Response ex) {
		
			response.setStatus(getMessage("userAdd.error")+ user.getClass());
			response.setMessage(ex.getLocalizedMessage());
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setLogger(user.getClass().getName(), response.getMessage(), "severe");
		}

		return response;
	}
	
	private String getMessage(String key) {
		
		return  env.getProperty("email.error");	
	}
	
	public Response getUsers(User user){
		List<Object> users = dao.getAll(user);
		response.setReponseDataList(users);
		response.setMessage("list of users");
		return response;	
	}
	public Response getUser(User user,String field,String userName){
		List<Object> allByCriteria = dao.getAllByCriteria(user, field, userName);
		response.setReponseDataList(allByCriteria);
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
	
	
	

}

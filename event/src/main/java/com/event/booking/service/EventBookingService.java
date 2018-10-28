package com.event.booking.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.event.booking.dao.IEventBookingDao;
import com.event.booking.model.User;
import com.event.booking.response.Response;

@Service
@Transactional
public class EventBookingService {
	@Autowired
	private IEventBookingDao dao;
	@Autowired
	Response response;
	
	public Response addUser(User user) {
		
		try {
			
			response = dao.add(user);
			response.setView("main");
			
		} catch (Response ex) {
		
			response.setStatus("add failed: "+ user.getClass());
			response.setMessage(ex.getLocalizedMessage());
			response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
			response.setLogger(user.getClass().getName(), response.getMessage(), "severe");
		}

		return response;
	}
	
	public Response getInitPage() {
		Response response = new Response();
		response.setView("main");
		return response;	
	}
	

}

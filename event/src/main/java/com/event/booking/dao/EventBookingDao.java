package com.event.booking.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.event.booking.response.Response;

@Repository
public class EventBookingDao implements IEventBookingDao {

	@Autowired
	private SessionFactory factory;
	@Autowired
	Response response;

	private Session getSession() {
		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (HibernateException ex) {
			session = factory.openSession();
		}
		return session;
	}

	@Override
	public Response add(Object object) throws Response  {
		
		getSession().save(object);
		response.setStatus("add success : "+ object.getClass());
		response.setMessage("operation success "+ object.getClass());
		response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
		response.setResponseData(object);
		return response;

	}

}

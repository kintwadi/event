package com.event.booking.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.event.booking.model.User;
import com.event.booking.response.Response;
import com.event.booking.response.Validator;

@Repository
public class EventBookingDao implements IEventBookingDao {

	@Autowired
	private SessionFactory factory;

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
	public void add(Object object) throws Response {

		
		getSession().save(object);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAll(Object clazz) {
		
		return getSession().createCriteria(clazz.getClass()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAllByCriteria(Object clazz, String field, String criteria) {
		return getSession().createCriteria(clazz.getClass()).add(Restrictions.eq(field, criteria)).list();
	}

}

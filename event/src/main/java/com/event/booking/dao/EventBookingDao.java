package com.event.booking.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.event.booking.model.Comment;
import com.event.booking.model.Event;
import com.event.booking.model.Image;
import com.event.booking.model.User;
import com.event.booking.response.Response;

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
	
	public void update(Object object) {
		getSession().saveOrUpdate(object);
	}

	@Override
	public void remove(Object object) {
	
		getSession().delete(object);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAll(Object clazz) {
		
		if(clazz instanceof User) {
			
			return getSession().createCriteria(User.class).list();
		}
		if(clazz instanceof Event) {
			
			return getSession().createCriteria(Event.class).list();
		}
		if(clazz instanceof Comment) {
			
			return getSession().createCriteria(Comment.class).list();
		}
       if(clazz instanceof Image) {
			
			return getSession().createCriteria(Image.class).list();
		}
		return null;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAllByCriteria(Object clazz, String criteria) {
		return getSession().createCriteria(clazz.getClass()).add(Restrictions.eq(criteria, criteria)).list();
	}

	@Override
	public Object getById(Object clazz,long id) {
		clazz = getSession().get(clazz.getClass(), id);
		return  clazz;
	}

	@Override
	public Object getByEmail(Object clazz, String email) {
		
		List list = getSession().createCriteria(clazz.getClass()).add(Restrictions.eq("email", email)).list();
		
		return list!= null ? list.get(0):  null;
		
	}

	@Override
	public Object getElementByFieldName(String className, String field, String value) {
		
		StringBuilder str = new StringBuilder("From ");
		str.append(className);
		str.append(" where ");
		str.append(field);
		str.append(" =:"+field);
	
		Query query  = getSession().createQuery(str.toString());
		query.setParameter(field,value );
		
		
		return query.list().get(0);
	}


}
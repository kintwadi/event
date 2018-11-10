package com.event.booking.dao;

import java.util.List;

import com.event.booking.response.Response;

public interface IEventBookingDao {
	
	
	public void add(Object object) throws Response;
	public List<Object>getAll(Object clazz);
	public List<Object>getAllByCriteria(Object clazz, String field,String criteria);

}

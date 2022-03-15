package com.project.attendance.dao;


import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.attendance.models.AttendanceModel;

@Component("attendanceDAO")
public class AttendanceDAO implements IAttendanceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Map<String, String> insertDoc(AttendanceModel doc) {
		sessionFactory.getCurrentSession().save(doc);
		sessionFactory.getCurrentSession().flush();

		return null;
	}
	
	@Override
	@Transactional
	public List<AttendanceModel> getAllDoc() {
		String hql = "FROM AttendanceModel";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		List<AttendanceModel> teacher = query.list();
		
		return teacher;
	}
}

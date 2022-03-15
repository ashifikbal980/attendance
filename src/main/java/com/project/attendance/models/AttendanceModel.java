package com.project.attendance.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;;

@Entity
@Table(name = "attendance")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AttendanceModel {
	
	@Id
	@Column(name = "uuid")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uuid;
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "day")
	private String day;
	
	@Column(name = "id")
	private String id;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "first_in_time")
	private String firstInTime;
	
	@Column(name = "last_out_time")
	private String lastOutTime;
	
	@Column(name = "hours_of_work")
	private String hoursOfWork;
	
	
	
	
	
	
	

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getFirstInTime() {
		return firstInTime;
	}

	public void setFirstInTime(String firstInTime) {
		this.firstInTime = firstInTime;
	}

	public String getLastOutTime() {
		return lastOutTime;
	}

	public void setLastOutTime(String lastOutTime) {
		this.lastOutTime = lastOutTime;
	}

	public String getHoursOfWork() {
		return hoursOfWork;
	}

	public void setHoursOfWork(String hoursOfWork) {
		this.hoursOfWork = hoursOfWork;
	}
	
}

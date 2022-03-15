package com.project.attendance.dao;

import java.util.List;
import java.util.Map;

import com.project.attendance.models.AttendanceModel;

public interface IAttendanceDAO {

	public Map<String, String> insertDoc(AttendanceModel doc);

	public List<AttendanceModel> getAllDoc();

}

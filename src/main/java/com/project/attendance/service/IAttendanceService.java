package com.project.attendance.service;

import java.util.List;
import java.util.Map;

import com.project.attendance.models.AttendanceModel;

public interface IAttendanceService {

	public Map<String, String> insert();

	public List<AttendanceModel> getAll();

}

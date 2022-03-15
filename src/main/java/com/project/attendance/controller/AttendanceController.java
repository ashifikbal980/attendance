package com.project.attendance.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.attendance.service.IAttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
	private IAttendanceService attendanceService;
	
	@RequestMapping("/upload")
	public ModelAndView upload() {
		
		return new ModelAndView("/upload/uploadpage");
	}
	
	@RequestMapping("/uploadcsv")
	public Map<String, String> uploadCsv() {
		
		attendanceService.insert();
		
		return null;
	}
	
	@RequestMapping("/report")
	public ModelAndView report() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("attendanceData", attendanceService.getAll());
		
		return new ModelAndView("/report/report", "map", map);
	}
	
}

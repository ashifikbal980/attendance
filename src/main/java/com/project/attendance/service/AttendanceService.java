package com.project.attendance.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.attendance.dao.IAttendanceDAO;
import com.project.attendance.models.AttendanceModel;

@Service("attendanceService")
public class AttendanceService implements IAttendanceService{
	
	@Autowired
	private IAttendanceDAO attendanceDAO;
	
	@Override
	public Map<String, String> insert() {
		
		try {
    		FileInputStream file = new FileInputStream(new File("Attendance_Sheet.xlsx"));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();
			while(sheets.hasNext()) {
				Sheet sh = sheets.next();
				Iterator<Row> iterator = sh.iterator();
				
				while(iterator.hasNext()) {
					Row row = iterator.next();
					if(iterator.hasNext()) {
						row = iterator.next();
					}
					Iterator<Cell> cellIterator = row.iterator();
					
					List<String> dataHolder = new ArrayList();
					
					AttendanceModel attendance = new AttendanceModel();
					
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						
						dataHolder.add(cellValue);
					}
					
					try {
						attendance.setMonth(dataHolder.get(0));
						attendance.setDate(dataHolder.get(1));
						attendance.setDay(dataHolder.get(2));
						attendance.setId(dataHolder.get(3));
						attendance.setEmployeeName(dataHolder.get(4));
						attendance.setDepartment(dataHolder.get(5));
						attendance.setFirstInTime(dataHolder.get(6));
						attendance.setLastOutTime(dataHolder.get(7));
						attendance.setHoursOfWork(dataHolder.get(8));
					}catch(ArrayIndexOutOfBoundsException e) {}
					
					attendanceDAO.insertDoc(attendance);
				}
				
			}
			workbook.close();
    	
    	}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<AttendanceModel> getAll(){
		
		return attendanceDAO.getAllDoc();
	}
	
}

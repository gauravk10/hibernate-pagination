package com.nit.dao;

import java.util.List;

import com.nit.entity.Employee;

public interface EmployeeReportDAO {
	
	public long getRecordCount();
	
	public List<Employee> getEmployeeData(int startPosition,int pageSize);
	

}

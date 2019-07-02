package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import com.nit.dao.EmployeeReportDAO;
import com.nit.dao.EmployeeReportDAOImpl;
import com.nit.dto.EmployeeDTO;
import com.nit.entity.Employee;

public class EmployeeReportServiceImpl implements EmployeeReportService {

	private EmployeeReportDAO empReportDAO;

	public EmployeeReportServiceImpl() {
		empReportDAO = new EmployeeReportDAOImpl();
	}

	@Override
	public int fetchPageCount(int pageSize) {
		int recordCount = 0, pageNumber = 0;
		recordCount = (int) empReportDAO.getRecordCount();
		pageNumber = recordCount / pageSize;
		if (recordCount % pageSize != 0)
			pageNumber++;
		return pageNumber;
	}

	@Override
	public List<EmployeeDTO> fetchEmployeeRecord(int pageNumber, int pageSize) {
		int startPosition = 0;
		List<Employee> empList = null;
		List<EmployeeDTO> empDTOList = new ArrayList<EmployeeDTO>();
		startPosition = pageNumber * pageSize - pageSize;
		// use dao to invoke method
		empList = empReportDAO.getEmployeeData(startPosition, pageSize);
		// copy data from empList to empDTOList
		empList.forEach(employee -> {
			EmployeeDTO empDTO = new EmployeeDTO();
			empDTO.setEmpadd(employee.getEmpadd());
			empDTO.setEmpname(employee.getEmpname());
			empDTO.setEmpno(employee.getEmpno());
			empDTO.setEmpsal(employee.getEmpsal());
			// add empDTO to empDTOList collection
			empDTOList.add(empDTO);
		});
		return empDTOList;
	}//method

}//class

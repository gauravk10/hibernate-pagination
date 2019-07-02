package com.nit.service;

import java.util.List;

import com.nit.dto.EmployeeDTO;

public interface EmployeeReportService {

	public int fetchPageCount(int pageSize);

	public List<EmployeeDTO> fetchEmployeeRecord(int pageNumber, int pageSize);

}

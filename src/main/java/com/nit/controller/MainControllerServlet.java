package com.nit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.dto.EmployeeDTO;
import com.nit.service.EmployeeReportService;
import com.nit.service.EmployeeReportServiceImpl;

public class MainControllerServlet extends HttpServlet {

	private EmployeeReportService empReportService;

	@Override
	public void init() throws ServletException {
		empReportService = new EmployeeReportServiceImpl();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MainControllerServlet.doGet()");
		int pageSize = 0, pageNumber = 0, pageCount = 0;
		String pNo = null, pSize = null;
		List<EmployeeDTO> empDTOList = null;
		RequestDispatcher rd = null;
		// read form data
		pNo = req.getParameter("pageNumber");
		pageSize = Integer.parseInt(req.getParameter("pagesize"));
		if (pNo == null)
			pageNumber = 1;
		else
			pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
		// use service object to invoke methods
		empDTOList = empReportService.fetchEmployeeRecord(pageNumber, pageSize);
		pageCount = empReportService.fetchPageCount(pageSize);
		// place empDTOList,pageCount in request scope and forward control to
		// show_report.jsp
		req.setAttribute("empList", empDTOList);
		req.setAttribute("pagecount", pageCount);
		// create RequestDispatcher object
		rd = req.getRequestDispatcher("/show_report.jsp");
		// forward the request
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MainControllerServlet.doPost()");
		doGet(req, res);
	}// doPost(-,-)

}

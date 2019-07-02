package com.nit.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	
	private int empno;
	private String empname;
	private String empadd;
	private int empsal;

}

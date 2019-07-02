package com.nit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Employee;
import com.nit.utility.HibernateUtils;

public class EmployeeReportDAOImpl implements EmployeeReportDAO {

	@Override
	public long getRecordCount() {
		Session session = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<Object> ctQuery = null;
		List<Object> list = null;
		Root root = null;
		Query query = null;
		Transaction tx = null;
		// get session object
		session = HibernateUtils.getSession();
		// begin transaction
		tx = session.beginTransaction();
		// create CriteriaBuilder object
		builder = session.getCriteriaBuilder();
		// create CriteriaQuery object
		ctQuery = builder.createQuery(Object.class);
		// create Root object
		root = ctQuery.from(Employee.class);
		ctQuery.multiselect(builder.count(root.get("empno")));
		// create Query object
		query = session.createQuery(ctQuery);
		// execute the qbc
		list = query.getResultList();
		tx.commit();
		return (long) list.get(0);
	}

	@Override
	public List<Employee> getEmployeeData(int startPosition, int pageSize) {
		Session session = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<Employee> ctQuery = null;
		Root<Employee> root = null;
		Query query = null;
		Transaction tx = null;
		List<Employee> empList = new ArrayList<>();
		// get session object
		session = HibernateUtils.getSession();
		// begin transaction
		tx = session.beginTransaction();
		// create CriteriaBuilder object
		builder = session.getCriteriaBuilder();
		// create CriteriaQuery object
		ctQuery = builder.createQuery(Employee.class);
		// create root object
		root = ctQuery.from(Employee.class);
		// add root object to CriteriaQuery
		ctQuery.select(root);
		// create query object
		query = session.createQuery(ctQuery);
		query.setFirstResult(startPosition);
		query.setMaxResults(pageSize);
		// execute the query
		empList = query.getResultList();
		tx.commit();
		return empList;
	}

}

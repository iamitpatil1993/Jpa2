package com.example.jpa.beans.identitygeneration.table;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.identitygeneration.table.EmployeeIdGenTable;

@Stateless
public class EmployeeIdGenTableDemoBean {
	
	private static final Logger LOGGER = Logger.getLogger(EmployeeIdGenTableDemoBean.class);
	
	@PersistenceContext(unitName="JPADB")
	private EntityManager entityManager;

	
	public void create() {
		EmployeeIdGenTable employeeIdGenTable = new EmployeeIdGenTable();
		entityManager.persist(employeeIdGenTable);
		
		LOGGER.info("EmployeeIdGenTable saved successfully with ID :: " + employeeIdGenTable.getEmployeeId());
	}
}

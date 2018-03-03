package com.example.jpa.beans.enumeration;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.enumeration.EmployeeSimpleEnumeration;
import com.example.jpa.domain.enumeration.EmployeeType;
import com.example.jpa.domain.enumeration.Gender;
import com.example.jpa.domain.enumeration.MaritalStatus;

@Stateless
public class EmployeeEnumerationDemoBean {

	private static final Logger LOGGER = Logger.getLogger(EmployeeEnumerationDemoBean.class);

	@PersistenceContext(unitName="JPADB")
	private EntityManager entityManager;
	
	public void createSimpleEnumMappingEmployee() {
		
		EmployeeSimpleEnumeration employeeSimpleEnumeration = new EmployeeSimpleEnumeration();
		employeeSimpleEnumeration.setEmployeeType(EmployeeType.FULL_TIME);
		employeeSimpleEnumeration.setfName("Amit");
		employeeSimpleEnumeration.setGender(Gender.MALE);
		employeeSimpleEnumeration.setlName("Patil");
		employeeSimpleEnumeration.setMaritalStatus(MaritalStatus.SINGLE);
		
		entityManager.persist(employeeSimpleEnumeration);
		LOGGER.info("EmployeeSimpleEnumeration saved successfully with employeeId :: " + employeeSimpleEnumeration.getEmployeeId());
	}
}

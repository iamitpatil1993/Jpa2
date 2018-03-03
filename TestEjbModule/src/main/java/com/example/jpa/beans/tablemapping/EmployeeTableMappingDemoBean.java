package com.example.jpa.beans.tablemapping;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.tablemapping.EmployeeTableMappingDemo;

@Stateless
public class EmployeeTableMappingDemoBean {

	private static final Logger LOGGER = Logger.getLogger(EmployeeTableMappingDemoBean.class);

	@PersistenceContext(unitName = "JPADB")
	private EntityManager em;

	public void create() {

		try {
			EmployeeTableMappingDemo employeeTableMappingDemo = new EmployeeTableMappingDemo();
			employeeTableMappingDemo.setfName("Amit");
			employeeTableMappingDemo.setlName("Patil");
			employeeTableMappingDemo.setPhoneNo("8983099123");

			em.persist(employeeTableMappingDemo);
			LOGGER.info("Employee saved successfully with employeeId :: " + employeeTableMappingDemo.getEmployeeId());
		} catch (Exception e) {
			LOGGER.info("Erroe while saving employee");
			e.printStackTrace();

		}
	}
}

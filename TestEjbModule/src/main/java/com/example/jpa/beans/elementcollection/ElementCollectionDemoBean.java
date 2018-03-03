package com.example.jpa.beans.elementcollection;

import java.net.Inet4Address;
import java.util.Arrays;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.elementcollection.AddressEmbeddable;
import com.example.jpa.domain.elementcollection.EmployeeUsingElementCollection;

/**
 * Session Bean implementation class ElementCollectionDemoBean
 */
@Stateless
@LocalBean
public class ElementCollectionDemoBean {

	private static final Logger LOGGER = Logger.getLogger(ElementCollectionDemoBean.class);
	
	@PersistenceContext(unitName = "JPADB")
	private EntityManager entityManager;
	
	public void createEmployee() {
		EmployeeUsingElementCollection emp = new EmployeeUsingElementCollection();
		emp.setName("Amit Patil");
		entityManager.persist(emp);
		LOGGER.info("Employee Saved successfully with id :: " + emp.getEmployeeId());
	}

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void getEmployee(Integer employeeId) {
		EmployeeUsingElementCollection emp = entityManager.find(EmployeeUsingElementCollection.class, employeeId);
		System.out.println("EmployeeUsingElementCollection found by id :: " + emp.getEmployeeId());
		System.out.println("Is entity managed ? -> " + entityManager.contains(emp));;
		emp.setName("rocks");
	}

	public void createEmployeeWithCollections() {
		EmployeeUsingElementCollection emp = new EmployeeUsingElementCollection();
		emp.setName("kajal kakale");
		emp.setNicknames(Arrays.asList("Kajal", "kju"));
		emp.setAddress(Arrays.asList(new AddressEmbeddable("street", "city", "state", "country"), new AddressEmbeddable("streeta", "citya", "statea", "countrya")));
		entityManager.persist(emp);
		LOGGER.info("Employee Saved successfully with id :: " + emp.getEmployeeId());
	}

	public void updateEmploteeName(final String name, Integer empId) {
		EmployeeUsingElementCollection emp = entityManager.find(EmployeeUsingElementCollection.class, empId);
		emp.setName(name);
		entityManager.merge(emp);
		LOGGER.info("Employee updated successfully with id :: " + emp.getEmployeeId());
	}
	
	public void addNickNameToEmployee(Integer employeeId, final String name) {
		EmployeeUsingElementCollection emp = entityManager.find(EmployeeUsingElementCollection.class, employeeId);
		emp.addNickname(name);
		entityManager.merge(emp);
		LOGGER.info("Nickname added to mployee with id :: " + emp.getEmployeeId());
	}
	
	public void removeNickNameToEmployee(Integer employeeId, final String name) {
		EmployeeUsingElementCollection emp = entityManager.find(EmployeeUsingElementCollection.class, employeeId);
		emp.removeNickName(name);
		entityManager.merge(emp);
		LOGGER.info("Nickname removed to mployee with id :: " + emp.getEmployeeId());
	}
	
	public void displayEmployeeAddress(Integer employeeId) {
		EmployeeUsingElementCollection emp = entityManager.find(EmployeeUsingElementCollection.class, employeeId);
		LOGGER.info("Address of employee with empId :: " + employeeId);
		emp.getAddress().stream().forEach(LOGGER::info);
		
	}
}

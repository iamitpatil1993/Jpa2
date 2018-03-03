package com.example.jpa.beans.accesstypes.property;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.accesstypes.property.EmployeePropertyAccess;

@Stateless
public class PropertyAccessTypeDemoBean {

	private static final Logger LOGGER = Logger.getLogger(PropertyAccessTypeDemoBean.class);
	
	@PersistenceContext(unitName="JPADB")
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create() {
		
		EmployeePropertyAccess employeePropertyAccess = new EmployeePropertyAccess();
		employeePropertyAccess.setfName("AMit via Property access");
		employeePropertyAccess.setlName("patil via property access");
		employeePropertyAccess.setPaSalary(540000);
		
		em.persist(employeePropertyAccess);
		LOGGER.info("Employee created successfully with property access with id :: " + employeePropertyAccess.getEmployeeId());
	}

	
}

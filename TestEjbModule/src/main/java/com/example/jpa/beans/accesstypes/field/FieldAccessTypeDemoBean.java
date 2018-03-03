package com.example.jpa.beans.accesstypes.field;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.accesstypes.field.EmployeeFieldAccess;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FieldAccessTypeDemoBean {

	private static final Logger LOGGER = Logger.getLogger(FieldAccessTypeDemoBean.class);
	
	@PersistenceContext(unitName="JPADB")
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create() {
		
		EmployeeFieldAccess employeeFieldAccess = new EmployeeFieldAccess();
		employeeFieldAccess.setfName("Amit");
		employeeFieldAccess.setlName("Patil");
		employeeFieldAccess.setPaSalary(540000);
		
		em.persist(employeeFieldAccess);
		LOGGER.info("Employee created successfully with field access with id :: " + employeeFieldAccess.getEmployeeId());
	}

	
}

package com.example.jpa.beans.identitygeneration.identity;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.apache.log4j.Logger;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmployeeIdGenIdentityDemoBean {
	
	private static final Logger LOGGER = Logger.getLogger(EmployeeIdGenIdentityDemoBean.class);
	
	@PersistenceContext(unitName="JPADB")
	private EntityManager entityManager;

	public void create() {
		
		EmployeeIdGenIdentity employeeIdGenIdentityEntity = new EmployeeIdGenIdentity();
		entityManager.persist(employeeIdGenIdentityEntity);
		LOGGER.info("EmployeeIdGenIdentity saved successfully with Id :: " + employeeIdGenIdentityEntity.getEmployeeId());
	}
	
	public EmployeeIdGenIdentity findByEmployeeId(Integer employeeId) {
		return entityManager.find(EmployeeIdGenIdentity.class, employeeId);
	}
}

package com.example.jpa.beans.identitygeneration.sequence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.identitygeneration.sequence.EmployeeIdGenSequence;

@Stateless
public class EmployeeIdGenSequenceDemoBean {
	
	private static final Logger LOGGER = Logger.getLogger(EmployeeIdGenSequenceDemoBean.class);
	
	@PersistenceContext(unitName="JPADB")
	private EntityManager entityManager;

	
	public void create() {
		EmployeeIdGenSequence employeeIdGenSequence = new EmployeeIdGenSequence();
		entityManager.persist(employeeIdGenSequence);
		
		LOGGER.info("EmployeeIdGenSequence saved successfully with ID :: " + employeeIdGenSequence.getEmployeeId());
	}


}

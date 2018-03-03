package com.example.jpa.beans.enumeration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.enumeration.AccessAuthority;
import com.example.jpa.domain.enumeration.EmployeeCustomEnumEnumeration;

@Stateless
public class EmployeeCustomEnumDemoBean {

	private static final Logger LOGGER = Logger.getLogger(EmployeeCustomEnumDemoBean.class);

	@PersistenceContext(unitName = "JPADB")
	private EntityManager entityManager;

	public void createCustomEnumMappingEmployee() {

		EmployeeCustomEnumEnumeration employeeCustomEnumeration = new EmployeeCustomEnumEnumeration();
		employeeCustomEnumeration.setfName("Amit");
		employeeCustomEnumeration.setlName("Patil");
		employeeCustomEnumeration.setAccessAuthority(AccessAuthority.READ);

		entityManager.persist(employeeCustomEnumeration);
		LOGGER.info("EmployeeSimpleEnumeration saved successfully with employeeId :: "
				+ employeeCustomEnumeration.getEmployeeId());
	}

	public EmployeeCustomEnumEnumeration findByEmployeeId(Integer employeeId) {
		return entityManager.find(EmployeeCustomEnumEnumeration.class, employeeId);
	}
}

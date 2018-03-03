package com.example.jpa.beans.lob.binary;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.lob.binary.BinaryLobEmployee;

@Stateless
public class BinaryLobEmployeeDemoBean {

	private static final Logger LOGGER = Logger.getLogger(BinaryLobEmployeeDemoBean.class);

	@PersistenceContext(unitName = "JPADB")
	private EntityManager entityManager;

	public void create(byte[] employeeProfilePic) {

		BinaryLobEmployee binaryLobEmployee = new BinaryLobEmployee();
		binaryLobEmployee.setEmployeeImage(employeeProfilePic);

		entityManager.persist(binaryLobEmployee);
		LOGGER.info("BinaryLobEmployee saved successfullly with employee id ::  " + binaryLobEmployee.getEmployeeId());
	}
	
	public byte[] getEmployeeProfilePic(Integer employeeId) {
		return entityManager.find(BinaryLobEmployee.class, employeeId).getEmployeeImage();
	}
}

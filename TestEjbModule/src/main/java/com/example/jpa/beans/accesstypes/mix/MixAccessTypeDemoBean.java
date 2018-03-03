package com.example.jpa.beans.accesstypes.mix;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.accesstypes.mix.EmployeeMixAccess;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MixAccessTypeDemoBean {

	private static final Logger LOGGER = Logger.getLogger(MixAccessTypeDemoBean.class);

	@PersistenceContext(unitName = "JPADB")
	private EntityManager em;

	public void create() {

		EmployeeMixAccess employeeMixAccess = new EmployeeMixAccess();

		employeeMixAccess.setfName("Amit");
		employeeMixAccess.setlName("Pail");
		employeeMixAccess.setPaSalary(540000);

		em.persist(employeeMixAccess);
		LOGGER.info("Employee saved successfuly using mix access with employeeId :: " + employeeMixAccess.getEmployeeId());
	}

	public EmployeeMixAccess get(Integer employeeId) {
		
		return em.find(EmployeeMixAccess.class, employeeId);
	}

}

package com.example.jpa.domain.embeddable;

import java.util.Calendar;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

/**
 * Session Bean implementation class EmbeddableDemoBean
 */
@Stateless
@LocalBean
public class EmbeddableDemoBean {

	private static final Logger LOGGER = Logger.getLogger(EmbeddableDemoBean.class);

	@PersistenceContext(unitName = "JPADB")
	private EntityManager entityManager;

	public EmbeddableDemoBean() {
	}

	public void createEmployee() {
		EmployeeWithEmbeddable embeddable = new EmployeeWithEmbeddable();
		embeddable.setName("Amit");
		embeddable.setAuditLog(new AuditLog(Calendar.getInstance(), Calendar.getInstance(), false));
		entityManager.persist(embeddable);
		LOGGER.info("EmployeeWithEmbeddable saved successfully with ID :: " + embeddable.getEmployeeId());
	}

	public void getEmployee(Integer employeeId) {
		EmployeeWithEmbeddable embeddable = entityManager.find(EmployeeWithEmbeddable.class, employeeId);
		LOGGER.info("EmployeeWithEmbeddable is :: " + embeddable);
	}
}
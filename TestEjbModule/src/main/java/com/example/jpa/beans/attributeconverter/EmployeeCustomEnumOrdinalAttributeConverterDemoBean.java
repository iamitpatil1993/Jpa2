package com.example.jpa.beans.attributeconverter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.attributeconverter.EmployeeCustomEnumOrdinalAttributeConverter;
import com.example.jpa.domain.attributeconverter.EmployeeCustomEnumStringAttributeConverter;
import com.example.jpa.domain.enumeration.AccessAuthority;
import com.example.jpa.domain.enumeration.EmployeeType;

@Stateless
public class EmployeeCustomEnumOrdinalAttributeConverterDemoBean {

	private static final Logger LOGGER = Logger.getLogger(EmployeeCustomEnumOrdinalAttributeConverterDemoBean.class);

	@PersistenceContext(unitName="JPADB")
	private EntityManager entityManager;

	public void createEmployeeCustomEnumOrdinalAttributeConverter() {

		EmployeeCustomEnumOrdinalAttributeConverter entity = new EmployeeCustomEnumOrdinalAttributeConverter();
		entity.setAccessAuthority(AccessAuthority.WRITE);

		entityManager.persist(entity);
		LOGGER.info("EmployeeCustomEnumOrdinalAttributeConverter saved successfully with Id :: " + entity.getEmployeeId());
	} 

	public EmployeeCustomEnumOrdinalAttributeConverter findEmployeeCustomEnumOrdinalAttributeConverterByEmployeeId(Integer employeeId) {
		return entityManager.find(EmployeeCustomEnumOrdinalAttributeConverter.class, employeeId);
	}

	public void createEmployeeCustomEnumStringAttributeConverter() {

		EmployeeCustomEnumStringAttributeConverter entity = new EmployeeCustomEnumStringAttributeConverter();
		entity.setEmployeeType(EmployeeType.FULL_TIME);
		entityManager.persist(entity);
		LOGGER.info("EmployeeCustomEnumStringAttributeConverter saved successfully with Id :: " + entity.getEmployeeId());
	} 

	public EmployeeCustomEnumStringAttributeConverter findEmployeeCustomEnumStringAttributeConverterByEmployeeId(Integer employeeId) {
		return entityManager.find(EmployeeCustomEnumStringAttributeConverter.class, employeeId);
	}
}

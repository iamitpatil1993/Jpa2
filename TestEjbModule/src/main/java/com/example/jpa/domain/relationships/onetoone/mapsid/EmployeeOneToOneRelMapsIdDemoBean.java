package com.example.jpa.domain.relationships.onetoone.mapsid;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

@Stateless
public class EmployeeOneToOneRelMapsIdDemoBean {

	private static final Logger LOGGER = Logger.getLogger(EmployeeOneToOneRelMapsIdDemoBean.class);

	@PersistenceContext(unitName = "JPADB")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createEmployeeUsingMapsId() {

		EmployeeUsingMapsId employee = new EmployeeUsingMapsId();
		employee.setfName("Amit");
		employee.setlName("Patil");
		em.persist(employee);
		LOGGER.info("Saved EmployeeUsingMapsId successfully with employeeId :: " + employee.getEmployeeId());
	}

	public void createParkingLotUsingMapsIdUsingEmployeeEntity(Integer employeeId) {

		EmployeeUsingMapsId employee = em.find(EmployeeUsingMapsId.class, employeeId);
		if (employee != null) {
			ParkingLotUsingMapsId parkingLot = new ParkingLotUsingMapsId();
			parkingLot.setNumber("EM16");
			parkingLot.setEmployee(employee);
			em.persist(parkingLot);
			LOGGER.info(
					"Saved ParkingLotUsingMapsId using employee entity successfully with parkingLotId :: " + parkingLot.getId());
		} else {
			LOGGER.error("Invalid Employee Id :: " + employeeId);
		}
	}

	public void createParkingLotUsingMapsIdUsingEmployeeReference(Integer employeeId) {

		EmployeeUsingMapsId employee = em.getReference(EmployeeUsingMapsId.class, employeeId);
		if (employee != null) {
			ParkingLotUsingMapsId parkingLot = new ParkingLotUsingMapsId();
			parkingLot.setNumber("EM16");
			parkingLot.setEmployee(employee);
			em.persist(parkingLot);
			LOGGER.info(
					"Saved ParkingLotUsingMapsId using employee entity successfully with parkingLotId :: " + parkingLot.getId());
		} else {
			LOGGER.error("Invalid Employee Id :: " + employeeId);
		}
	}

	public String findEmpoyeeById(Integer employeeId) {

		if (null != employeeId) {
			EmployeeUsingMapsId employee = em.find(EmployeeUsingMapsId.class, employeeId);
			if (null != employee) {
				return employee.toString();
			} else {
				return "Invalid employeeid, employeeNot found by id";
			}
		} else {
			return "Empty employeeId";
		}
	}

	public String findParkingLotById(Integer parkingLotId) {

		if (null != parkingLotId) {
			ParkingLotUsingMapsId lot = em.find(ParkingLotUsingMapsId.class, parkingLotId);
			if (null != lot) {
				return lot.toString();
			} else {
				return "Invalid parkingLotId";
			}
		} else {
			return "Empty  parking lot Id";
		}
	}

}

package com.example.jpa.beans.relationships.onetooneunidirectional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.relationships.onetoone.Employee;
import com.example.jpa.domain.relationships.onetoone.ParkingLot;

@Stateless
public class EmployeeOneToOneUnidirectionalRelDemoBean {

	private static final Logger LOGGER = Logger.getLogger(EmployeeOneToOneUnidirectionalRelDemoBean.class);

	@PersistenceContext(unitName = "JPADB")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createEmployee() {

		Employee employee = new Employee();
		employee.setfName("Amit");
		employee.setlName("Patil");

		em.persist(employee);
		LOGGER.info("Saved employee successfully with employeeId :: " + employee.getEmployeeId());
	}

	public void createParkingLotUsingEmployeeEntity(Integer employeeId) {

		Employee employee = em.find(Employee.class, employeeId);
		if (employee != null) {
			ParkingLot parkingLot = new ParkingLot();
			parkingLot.setNumber("EM16");
			parkingLot.setEmployee(employee);
			em.persist(parkingLot);
			LOGGER.info("Saved ParkingLot using employee entity successfully with parkingLotId :: "
					+ parkingLot.getParkingLotId());
		} else {
			LOGGER.error("Invalid Employee Id :: " + employeeId);
		}
	}

	public void createParkingLotUsingEmployeeReference(Integer employeeId) {

		Employee employee = em.getReference(Employee.class, employeeId);
		if (employee != null) {
			ParkingLot parkingLot = new ParkingLot();
			parkingLot.setNumber("EM16");
			parkingLot.setEmployee(employee);
			em.persist(parkingLot);
			LOGGER.info("Saved ParkingLot using employee reference successfully with parkingLotId :: "
					+ parkingLot.getParkingLotId());
		} else {
			LOGGER.error("Invalid Employee Id :: " + employeeId);
		}
	}

	public String findEmpoyeeById(Integer employeeId) {

		if (null != employeeId) {
			Employee employee = em.find(Employee.class, employeeId);
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
			ParkingLot lot = em.find(ParkingLot.class, parkingLotId);
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

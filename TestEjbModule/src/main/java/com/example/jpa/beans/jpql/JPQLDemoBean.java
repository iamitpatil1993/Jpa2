package com.example.jpa.beans.jpql;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.example.jpa.domain.jpql.DepartmentJPQL;
import com.example.jpa.domain.jpql.EmployeeJPQL;

@Stateless
public class JPQLDemoBean {

	private static final Logger LOGGER = Logger.getLogger(JPQLDemoBean.class);

	@PersistenceContext(unitName = "JPADB")
	private EntityManager em;

	public void createEmployee(final String fName, final String lName, Integer salary) {
		EmployeeJPQL employee = new EmployeeJPQL();
		employee.setfName(fName);
		employee.setlName(lName);
		employee.setSalary(salary);
		em.persist(employee);
		LOGGER.info("Employee saved successfully using ID :: " + employee.getEmployeeId());
	}

	public void createDepartment(final String departmentName) {
		DepartmentJPQL department = new DepartmentJPQL();
		department.setName(departmentName);
		em.persist(department);
		LOGGER.info("DepartmentJPQL saved successfully using ID :: " + department.getDepartmentId());
	}

	public void assignDepartmentToEmployee(Integer employeeId, Integer departmentId) {
		EmployeeJPQL employee = em.find(EmployeeJPQL.class, employeeId);
		DepartmentJPQL department = em.getReference(DepartmentJPQL.class, departmentId);
		employee.setDepartment(department);
		em.merge(employee);
		LOGGER.info("Employee with Id :: " + employeeId + " added to department with department id :: " + departmentId);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void findAllEmployees() {

		TypedQuery<EmployeeJPQL> query = em.createQuery("SELECT e FROM EmployeeJPQL e", EmployeeJPQL.class);
		List<EmployeeJPQL> employees = query.getResultList();

		LOGGER.info("EmployeeCount :: " + employees.size());
		LOGGER.info("Employee are :: ");
		employees.stream().forEach(LOGGER::info);
		LOGGER.info("Are Employees managed :: " + em.contains(employees.get(0)));
	}

	public void findAllEmployeesWithProjection() {

		TypedQuery<String> query = em.createQuery("SELECT CONCAT(e.fName, ' ', e.lName) FROM EmployeeJPQL e",
				String.class);
		List<String> employees = query.getResultList();

		LOGGER.info("EmployeeCount :: " + employees.size());
		LOGGER.info("Employee are :: ");
		employees.stream().forEach(LOGGER::info);
	}

	public void findAllEmployeesByFName(final String fName) {

		TypedQuery<EmployeeJPQL> query = em.createQuery(
				"SELECT e FROM EmployeeJPQL e WHERE CONCAT(e.fName, ' ', e.lName) LIKE :fName", EmployeeJPQL.class);
		query.setParameter("fName", "%" + fName + "%");
		List<EmployeeJPQL> employees = query.getResultList();

		LOGGER.info("EmployeeCount :: " + employees.size());
		LOGGER.info("Employee are :: ");
		employees.stream().forEach(LOGGER::info);
	}

	public void findAllemployeesByDepartmentName(final String departmentName) {

		TypedQuery<EmployeeJPQL> query = em.createQuery(
				"SELECT e FROM EmployeeJPQL e INNER JOIN e.department d WHERE d.name = ?1", EmployeeJPQL.class);
		query.setParameter(1, departmentName);
		List<EmployeeJPQL> employees = query.getResultList();

		LOGGER.info("EmployeeCount :: " + employees.size());
		LOGGER.info("Employee are :: ");
		employees.stream().forEach(LOGGER::info);
	}

	public void findAllemployeesByDepartmentNameWithProjection(final String departmentName) {

		Query query = em.createQuery(
				"SELECT CONCAT(e.fName, ' ', e.lName), d.name FROM EmployeeJPQL e INNER JOIN e.department d WHERE d.name = ?1");
		query.setParameter(1, departmentName);
		List<Object[]> employees = (List<Object[]>) query.getResultList();

		LOGGER.info("EmployeeCount :: " + employees.size());
		LOGGER.info("Employee are :: ");
		employees.stream().forEach(objects -> {
			LOGGER.info("Employee :: " + (String) objects[0] + " Department :: " + (String) objects[1]);
		});
	}

	public void aggregatesByDepartmentId(final Integer departmentId) {
		// max, min, avg,
		Query query = em.createQuery("SELECT MAX(e.salary), MIN(e.salary), AVG(e.salary) FROM EmployeeJPQL e INNER JOIN e.department d WHERE d.departmentId = :departmentId GROUP BY d.departmentId");
		query.setParameter("departmentId", departmentId);	
		Object[] values = (Object[]) query.getSingleResult();
		LOGGER.info("MAX :: " + values[0] + " MIN :: " + values[1] + " AvG :: " + values[2]);
	}
	
	public void findEmployeeSalaryUsingNamedQuery(final Integer employeeId) {
		TypedQuery<Integer> query = em.createNamedQuery("EmployeeJPQL.findSalaryByEmployeeId", Integer.class);
		query.setParameter("employeeId", employeeId);
		Integer empSalary = query.getSingleResult();
		LOGGER.info("Employee of employeeId :: " + employeeId + " has salary of :: " + empSalary);
	}
	
	public void findEmployeeHiredBetweenDates(Date fromDate, Date toDate) {
		TypedQuery<EmployeeJPQL> query = em.createNamedQuery("EmployeeJPQL.findAllBetweenHiredDates", EmployeeJPQL.class);
		query.setParameter("fromDate", fromDate, TemporalType.DATE);
		query.setParameter("toDate", toDate, TemporalType.DATE);
		List<EmployeeJPQL> employees = query.getResultList();
		employees.forEach(emp -> LOGGER.info(emp.getfName() + " " + emp.getlName() + " date of joining :: " + emp.getCreatedDate().getTime() + " isManaged :: " + em.contains(emp)));
	}
	
	public void findAllEmployeeFNameAndLNameUsingConstructorExpression() {
		TypedQuery<EmployeeJPQL> query = em.createNamedQuery("EmployeeJPQL.findAllFNameAndLName", EmployeeJPQL.class);
		query.getResultList().forEach(emp -> LOGGER.info(emp.getfName() + " " + emp.getlName()  + " isManaged :: " + em.contains(emp)));
	}
	
	public void findAllWithPagination(int pageNo, int pageSize) {
		TypedQuery<EmployeeJPQL> query = em.createNamedQuery("EmployeeJPQL.findAllFNameAndLName", EmployeeJPQL.class);
		LOGGER.info("fetching results between :: " + ((pageNo -1 ) * pageSize) + " and " + pageSize);
		query.setFirstResult((pageNo -1 ) * pageSize);
		query.setMaxResults(pageSize);
		query.getResultList().forEach(emp -> LOGGER.info(emp.getfName() + " " + emp.getlName()));
	}
	
	public void findAllWithFlushModeAuto() {
		EmployeeJPQL employee = new EmployeeJPQL();
		employee.setfName("dadasdasd");
		employee.setlName("adasdasdas");
		employee.setSalary(3233);
		em.persist(employee);
		LOGGER.info("Employee saved successfully using ID :: " + employee.getEmployeeId());	
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TypedQuery<Integer> query = em.createQuery("SELECT e.employeeId FROM EmployeeJPQL e", Integer.class);
		List<Integer> empIds = query.getResultList();
		empIds.forEach(LOGGER::info);
		LOGGER.info("contains :: " + empIds.contains(employee.getEmployeeId()));
	}
	
	public void findAllWithFlushModeCommit() {
		EmployeeJPQL employee = new EmployeeJPQL();
		// to test this set identity generation off, and set primary key manually, because if we use AUTO-INCrement in mysql.
		// persistence provider will any how execute the insert statement into database to get primary key generated at database level
		// and set to entity object. so  using any flush mode on following query will not have any impact.
		//employee.setEmployeeId(323);
		employee.setfName("dadasdasd");
		employee.setlName("adasdasdas");
		employee.setSalary(3233);
		em.persist(employee);
		LOGGER.info("Employee saved successfully using ID :: " + employee.getEmployeeId());	
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TypedQuery<Integer> query = em.createQuery("SELECT e.employeeId FROM EmployeeJPQL e", Integer.class).setFlushMode(FlushModeType.COMMIT);
		List<Integer> empIds = query.getResultList();
		empIds.forEach(LOGGER::info);
		LOGGER.info("contains :: " + empIds.contains(employee.getEmployeeId()));
	}
	
	public void findAllEmployeeByDepartmentWithDepartmentEntityAsAQueryParameter(final Integer departmentId) {
		DepartmentJPQL departmentJPQL = em.getReference(DepartmentJPQL.class, departmentId);
		TypedQuery<EmployeeJPQL> query = em.createQuery("SELECT e FROM EmployeeJPQL e INNER JOIN e.department d WHERE e.department = :departmentEntityObjecy", EmployeeJPQL.class);
		query.setParameter("departmentEntityObjecy", departmentJPQL);
		query.getResultList().forEach(emp -> LOGGER.info(emp.getfName() + " " + emp.getlName()));
	}
	
	public void selectMultipleEntitiesInSelectClauseAndCheckAreTheymanaged() {
		Query query = em.createQuery("SELECT e,  d FROM EmployeeJPQL e INNER JOIN e.department d");
		List<Object[]> results = query.getResultList();
		results.forEach(values -> {
			LOGGER.info("Is Employee managed :: " + em.contains((EmployeeJPQL)values[0]) + " Is Department managed :: " + em.contains((DepartmentJPQL)values[1]));
		});
	}
	
	
	public void updateEmployeeByEmployeeId(Integer employeeId, String fName) {
		em.createQuery("UPDATE EmployeeJPQL e SET e.fName = :fName WHERE e.employeeId = :empId").setParameter("fName", fName).setParameter("empId", employeeId).executeUpdate();
	}
	
	// Here I want to check what is difference between query created by JOIN and using path expression for association
	public void findEmployeesByDepartmentName(final String departmentName) {
		
		Query query = em.createQuery("SELECT e FROM EmployeeJPQL e JOIN e.department d WHERE d.name = :departmentName", EmployeeJPQL.class);
		query.setParameter("departmentName", departmentName);
		
		List<EmployeeJPQL> employees = query.getResultList();
		employees.forEach(System.out::println);
		
		em.flush();
		
		query = em.createQuery("SELECT e FROM EmployeeJPQL e WHERE e.department.name = :departmentName");
		query.setParameter("departmentName", departmentName);
		employees = query.getResultList();
		employees.forEach(System.out::println);
		
	}
	
	public void findEmployeesWithJoinCondition(Integer departmentId) {
		TypedQuery<EmployeeJPQL> query = em.createQuery("SELECT e FROM DepartmentJPQL d JOIN d.employees e ON e.salary > :salary WHERE d.departmentId = :departmentId", EmployeeJPQL.class);
		query.setParameter("departmentId", departmentId).setParameter("salary", 5000);
		
		query.getResultList().forEach(System.out::println);
	}
	
	
	public void findAllDepartmentsWithEmployeeUsingFetchJoin() {
		List<DepartmentJPQL> departemts = em.createQuery("SELECT DISTINCT d FROM DepartmentJPQL d JOIN FETCH d.employees").getResultList();
		departemts.forEach(department -> {
			department.getEmployees().stream().map(em::contains).forEach(System.out::println);
		});
	}
	
	public void findAllDepartmentWithProjectsAndEmployees() {
		List<DepartmentJPQL> departments = em.createQuery("SELECT d FROM DepartmentJPQL d LEFT JOIN FETCH d.employees LEFT JOIN FETCH d.projects", DepartmentJPQL.class).getResultList();
	
		HashSet<DepartmentJPQL> departmentSet = new HashSet<>(departments);
		LOGGER.info("departments count :: " + departmentSet.size());
		departmentSet.forEach(LOGGER::info);
	}
	
	public void findAllDepartmentWithProjectsAndEmployeesUsingDistinct() {
		List<DepartmentJPQL> departments = em.createQuery("SELECT DISTINCT d FROM DepartmentJPQL d LEFT JOIN FETCH d.employees LEFT JOIN FETCH d.projects", DepartmentJPQL.class).getResultList();
	
		LOGGER.info("departments count :: " + departments.size());
		departments.forEach(LOGGER::info);
	}
}

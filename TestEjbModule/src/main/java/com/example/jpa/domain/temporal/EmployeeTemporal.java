package com.example.jpa.domain.temporal;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="employee_temporal")
public class EmployeeTemporal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4171522032997005418L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	//java.sql tempral types Date, Time, Timestamp do not require any special mapping or metadata anntotations. 
	//The only way JDBC work with database temporal types is through java.sql temporal type classes. Hence we must use java.sql classes in JDBC code if write. java.util 
	//temporal classes won't work in case of JDBC.


	//In case of JPA mappig, if attribute type is java.sql temporal type out of Date, Time, Timestamp then we do not need any additional metadata 
	//aannotation, provider will check the java.sql temporal type and will map it to database type Date, Time or Timestamp
	//but mostly we use java.util temporal classes, so to map them we need to use @Temporal annotation and tell provider to which java.util temporal type
	//Date, Time or Timestamp we want to map java.util Date or Calender class.

	//NO Temporal annotation required here
	@Column(name="sql_date")
	private Date sqlDate; 

	//NO Temporal annotation required here
	@Column(name="sql_time")
	private Time sqlTime; 

	//NO Temporal annotation required here
	@Column(name="sql_timestamp")
	private Timestamp sqlTimestamp; 

	
	//Temporal annotation required here
	@Temporal(TemporalType.DATE)
	@Column(name="util_date")
	private java.util.Date utilDate; 


	//Temporal annotation required here
	@Temporal(TemporalType.TIME)
	@Column(name="util_time")
	private java.util.Date utilTime; 

	//Temporal annotation required here
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="util_timestamp")
	private java.util.Date utilTimestamp;

}

package com.example.jpa.domain.attributeconverter;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.jpa.domain.enumeration.EmployeeType;

@Entity
@Table(name="employee_custom_enum_string_attribute_converter")
public class EmployeeCustomEnumStringAttributeConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6937511820685905260L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer employeeId;

	// NOTE: Attribute converter do not get applied to : Id fields, version fields, attribute EXPLICITLY annoted with Enumerated or Temporal annotation.
	// So, in order to appy attribute converter on eunum field we should not annotate it with @EnumeratedAnnotation

	@Basic
	@Convert(converter=EmployeeTypeStringConverter.class)
	@Column(name="employee_type")
	private EmployeeType employeeType;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public String toString() {
		return "EmployeeCustomEnumStringAttributeConverter [employeeId=" + employeeId + ", employeeType=" + employeeType
				+ "]";
	}

}

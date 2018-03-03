package com.example.jpa.domain.attributeconverter;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.jpa.domain.enumeration.AccessAuthority;

@Entity
@Table(name="employee_custom_enum_ordinal_attribute_converter")
public class EmployeeCustomEnumOrdinalAttributeConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7635751323878135238L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer employeeId;

	// NOTE: Attribute converter do not get applied to : Id fields, version fields, attribute EXPLICITLY annoted with Enumerated or Temporal annotation.
	// So, in order to appy attribute converter on eunum field we should not annotate it with @EnumeratedAnnotation

	@Basic
	@Convert(converter=AccessAuthorityOrdinalConverter.class)
	@Column(name="access_authority")
	private AccessAuthority accessAuthority;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public AccessAuthority getAccessAuthority() {
		return accessAuthority;
	}

	public void setAccessAuthority(AccessAuthority accessAuthority) {
		this.accessAuthority = accessAuthority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EmployeeCustomEnumOrdinalAttributeConverter [employeeId=" + employeeId + ", accessAuthority="
				+ accessAuthority + "]";
	} 
}

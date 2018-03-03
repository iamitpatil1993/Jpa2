package com.example.jpa.domain.attributeconverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.jpa.domain.enumeration.EmployeeType;

@Converter(autoApply=false)
public class EmployeeTypeStringConverter implements AttributeConverter<EmployeeType, String> {

	@Override
	public String convertToDatabaseColumn(EmployeeType attribute) {
		return attribute.equals(EmployeeType.FULL_TIME) ? "F_T" : "P_T";
	}

	@Override
	public EmployeeType convertToEntityAttribute(String dbData) {
		return dbData.equalsIgnoreCase("F_T") ? EmployeeType.FULL_TIME : EmployeeType.PART_TIME;
	}

}

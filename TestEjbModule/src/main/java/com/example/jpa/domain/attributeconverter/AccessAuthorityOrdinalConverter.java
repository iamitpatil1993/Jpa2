package com.example.jpa.domain.attributeconverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.log4j.Logger;

import com.example.jpa.domain.enumeration.AccessAuthority;

@Converter(autoApply=false)
public class AccessAuthorityOrdinalConverter implements AttributeConverter<AccessAuthority, Integer>{

	private static final Logger LOGGER = Logger.getLogger(AccessAuthorityOrdinalConverter.class);
	@Override
	public Integer convertToDatabaseColumn(AccessAuthority attribute) {
		LOGGER.info("AccessAuthorityOrdinalConverter.convertToDatabaseColumn called converting attribute : " + attribute + " to : " +  attribute.getAuthority());
		return attribute.getAuthority();
	}

	@Override
	public AccessAuthority convertToEntityAttribute(Integer dbData) {
		LOGGER.info("AccessAuthorityOrdinalConverter.convertToEntityAttribute called converting dbData : " + dbData + " to : " +  AccessAuthority.findByAccessValue(dbData));
		return AccessAuthority.findByAccessValue(dbData);
	}
}

package com.example.jpa.beans;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class HelloWorldBean {
	
	@PersistenceContext(unitName="JPADB")
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public String getGreetingMessage() {
		System.out.println("Entity manager injected successfully ->  " + em != null ? "yes" : "no");
		return "Hello world from first bean";
	}
}

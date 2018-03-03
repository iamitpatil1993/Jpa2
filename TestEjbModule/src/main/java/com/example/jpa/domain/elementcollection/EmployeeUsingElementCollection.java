package com.example.jpa.domain.elementcollection;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee_using_element_collection")
public class EmployeeUsingElementCollection implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Basic
	@Column(name = "name")
	private String name;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "employee_nickname", joinColumns = { @JoinColumn(name = "employee_id") })
	@Column(name = "nickname")
	List<String> nicknames = new ArrayList<>();

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "employee_address", joinColumns = { @JoinColumn(name = "employee_id") })
	@OrderBy("city desc")
	List<AddressEmbeddable> address =  new ArrayList<>();;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getNicknames() {
		return nicknames;
	}

	public void setNicknames(List<String> nicknames) {
		this.nicknames = nicknames;
	}

	public List<AddressEmbeddable> getAddress() {
		return address;
	}

	public void setAddress(List<AddressEmbeddable> address) {
		this.address = address;
	}
	
	public void addNickname(final String nickName) {
		nicknames.add(nickName);
	}
	
	public void removeNickName(final String nickName) {
		System.out.println("Nickname remved :: " + nicknames.remove(nickName));
	}
}
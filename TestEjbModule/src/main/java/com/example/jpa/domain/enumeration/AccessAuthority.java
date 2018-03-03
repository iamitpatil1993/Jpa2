package com.example.jpa.domain.enumeration;

import java.util.Arrays;
import java.util.List;

public enum AccessAuthority {
	READ(200), WRITE(300), EDIT(400);

	private Integer authority;

	AccessAuthority(Integer authority) {
		this.authority = authority;
	}

	public Integer getAuthority() {
		return authority;
	}

	public static AccessAuthority findByAccessValue(Integer authorityValue) {

		List<AccessAuthority> authorities = Arrays.asList(AccessAuthority.values());
		for (AccessAuthority authority : authorities) {
			if (authority.getAuthority().equals(authorityValue)) {
				return authority;
			}
		}
		return null;
	}
}

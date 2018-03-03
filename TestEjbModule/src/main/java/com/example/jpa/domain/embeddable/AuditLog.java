package com.example.jpa.domain.embeddable;
import javax.persistence.*;

import java.io.Serializable;
import java.util.Calendar;

@Embeddable
@Access(AccessType.FIELD)
public class AuditLog implements Serializable {

	private static final long serialVersionUID = -2149717166172269737L;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Calendar createdDate;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Calendar updatedDate;

	@Basic
	private boolean isDeleted;

	public AuditLog(Calendar createdDate, Calendar updatedDate, boolean isDeleted) {
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.isDeleted = isDeleted;
	}

	public AuditLog() {
	}


	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDemployee_with_embeddableate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuditLog other = (AuditLog) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuditLog [createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", isDeleted=" + isDeleted
				+ "]";
	}
}

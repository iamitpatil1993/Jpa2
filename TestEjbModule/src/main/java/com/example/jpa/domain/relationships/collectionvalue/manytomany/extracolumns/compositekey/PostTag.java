package com.example.jpa.domain.relationships.collectionvalue.manytomany.extracolumns.compositekey;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "post_tag")
public class PostTag implements Serializable {

	private static final long serialVersionUID = 4947320914537083815L;

	@EmbeddedId
	@AssociationOverrides({ @AssociationOverride(name = "post", joinColumns = { @JoinColumn(name = "post_id") }),
			@AssociationOverride(name = "tag", joinColumns = { @JoinColumn(name = "tag_id") }) })
	private PostTagId postTagId;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Calendar createdDate;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Calendar updatedDate;

	
	public PostTag(Post post, Tag tag) {
		this.postTagId = new PostTagId(post, tag);
	}

	public PostTag() {
	}

	
	public PostTagId getPostTagId() {
		return postTagId;
	}

	public void setPostTagId(PostTagId postTagId) {
		this.postTagId = postTagId;
	}

	public Post getPost() {
		return postTagId.getPost();
	}

	public void setPost(Post post) {
		this.postTagId.setPost(post);
	}

	public Tag getTag() {
		return  postTagId.getTag();
	}

	public void setTag(Tag tag) {
		this.setTag(tag);
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postTagId == null) ? 0 : postTagId.hashCode());
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
		PostTag other = (PostTag) obj;
		if (postTagId == null) {
			if (other.postTagId != null)
				return false;
		} else if (!postTagId.equals(other.postTagId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostTag [postTagId=" + postTagId + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}

	
}

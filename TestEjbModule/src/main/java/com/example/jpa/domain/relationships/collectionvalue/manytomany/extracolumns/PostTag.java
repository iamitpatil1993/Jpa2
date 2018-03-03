package com.example.jpa.domain.relationships.collectionvalue.manytomany.extracolumns;
import javax.persistence.*;

import com.example.jpa.domain.relationships.collectionvalue.manytomany.extracolumns.compositekey.Post;
import com.example.jpa.domain.relationships.collectionvalue.manytomany.extracolumns.compositekey.Tag;

import java.io.Serializable;
import java.util.Calendar;

@Entity(name = "PostTagWithSurrogateKey")
@Table(name = "post_tag_with_surrogate_key")
public class PostTag implements Serializable {

	private static final long serialVersionUID = -8058609856513462593L;

	@Basic
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "post_tag_id")
	private Integer postTagId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tag_id")
	private Tag tag;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Calendar createdDate;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Calendar updatedDate;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;

	public Integer getPostTagId() {
		return postTagId;
	}

	public void setPostTagId(Integer postTagId) {
		this.postTagId = postTagId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "PostTag [postTagId=" + postTagId + ", post=" + post + ", tag=" + tag.getTagId() + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", isDeleted=" + isDeleted + "]";
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
}

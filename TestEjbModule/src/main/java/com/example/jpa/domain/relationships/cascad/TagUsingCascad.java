package com.example.jpa.domain.relationships.cascad;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tag_using_cascad")
public class TagUsingCascad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private Integer tagId;

	@Basic
	@Column(name = "tag")
	private String tag;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private PostUsingCascad post;

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public PostUsingCascad getPost() {
		return post;
	}

	public void setPost(PostUsingCascad post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tagId == null) ? 0 : tagId.hashCode());
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
		TagUsingCascad other = (TagUsingCascad) obj;
		if (tagId == null) {
			if (other.tagId != null)
				return false;
		} else if (!tagId.equals(other.tagId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TagUsingCascad [tagId=" + tagId + ", tag=" + tag + ", post=" + post.getPostId() + "]";
	}

}

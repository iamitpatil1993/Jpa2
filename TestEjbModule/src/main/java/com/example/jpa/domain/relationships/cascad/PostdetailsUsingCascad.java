package com.example.jpa.domain.relationships.cascad;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "post_details_using_cascad")
public class PostdetailsUsingCascad implements Serializable {

	private static final long serialVersionUID = -1237626071101390313L;

	@Basic
	@Id
	@Column(name = "post_id")
	private Integer postId;

	@Column(name = "is_visible")
	private boolean isVisible;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Calendar createdDate;

	@OneToOne
	@JoinColumn(name = "post_id")
	@MapsId
	private PostUsingCascad post;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public PostUsingCascad getPost() {
		return post;
	}

	public void setPost(PostUsingCascad post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "PostdetailsUsingCascad [postId=" + postId + ", isVisible=" + isVisible + ", createdDate=" + createdDate
				+ ", post=" + post.getPostId() + "]";
	}

}

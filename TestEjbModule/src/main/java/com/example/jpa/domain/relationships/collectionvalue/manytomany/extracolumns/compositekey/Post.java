package com.example.jpa.domain.relationships.collectionvalue.manytomany.extracolumns.compositekey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post implements Serializable {

	private static final long serialVersionUID = -3445295687278364571L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Integer postId;

	@Basic
	@Column(name = "title")
	private String title;

	@Basic
	@Lob()
	@Column(name = "text")
	private String text;
	
	@OneToMany(mappedBy = "postTagId.post")
	private List<PostTag> tags = new ArrayList<>();

	public List<PostTag> getTags() {
		return tags;
	}

	public void setTags(List<PostTag> tags) {
		this.tags = tags;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postId == null) ? 0 : postId.hashCode());
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
		Post other = (Post) obj;
		if (postId == null) {
			if (other.postId != null)
				return false;
		} else if (!postId.equals(other.postId))
			return false;
		return true;
	}

}

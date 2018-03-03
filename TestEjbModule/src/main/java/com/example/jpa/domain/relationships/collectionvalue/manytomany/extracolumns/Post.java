package com.example.jpa.domain.relationships.collectionvalue.manytomany.extracolumns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "PostWithSurrogateKey")
@Table(name = "post_with_surrogate_key")
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

	@OneToMany(mappedBy = "post")
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

}

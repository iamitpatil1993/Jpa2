package com.example.jpa.domain.relationships.cascad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "post_using_cascad")
public class PostUsingCascad implements Serializable {

	private static final long serialVersionUID = 3355842606142046393L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Integer postId;

	@Basic
	@Column(name = "name")
	private String name;

	@OneToOne(mappedBy = "post")
	//@OneToOne(mappedBy = "post", cascade = CascadeType.PERSIST)
	private PostdetailsUsingCascad postdetails;

	@OneToMany(mappedBy = "post")
	private List<TagUsingCascad> tags = new ArrayList<>();

	public List<TagUsingCascad> getTags() {
		return tags;
	}

	public void setTags(List<TagUsingCascad> tags) {
		this.tags = tags;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PostdetailsUsingCascad getPostdetails() {
		return postdetails;
	}

	public void setPostdetails(PostdetailsUsingCascad postdetails) {
		this.postdetails = postdetails;
		postdetails.setPost(this);
	}

	public void addTag(TagUsingCascad tag) {
		if (tag != null) {
			tags.add(tag);
			tag.setPost(this);
		}
	}
}

package com.example.jpa.domain.relationships.collectionvalue.manytomany.extracolumns.compositekey;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class PostTagId implements Serializable {

	private static final long serialVersionUID = 3954621076168381943L;

	@ManyToOne
	private Post post;

	@ManyToOne
	private Tag tag;

	public PostTagId(Post post, Tag tag) {
		this.post = post;
		this.tag = tag;
	}

	public PostTagId() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
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
		PostTagId other = (PostTagId) obj;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostTagId [post=" + post.getPostId() + ", tag=" + tag.getTagId() + "]";
	}

}

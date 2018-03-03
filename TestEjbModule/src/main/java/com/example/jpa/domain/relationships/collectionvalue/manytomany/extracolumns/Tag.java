package com.example.jpa.domain.relationships.collectionvalue.manytomany.extracolumns;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "TagWithSurrogateKey")
@Table(name = "tag_with_surrogate_key")
public class Tag implements Serializable {

	private static final long serialVersionUID = 3143468461459261171L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private Integer tagId;

	@Basic
	@Column(name = "tag")
	private String tag;

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

}

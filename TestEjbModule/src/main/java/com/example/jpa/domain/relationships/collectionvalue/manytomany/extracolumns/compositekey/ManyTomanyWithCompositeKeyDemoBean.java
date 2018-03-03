package com.example.jpa.domain.relationships.collectionvalue.manytomany.extracolumns.compositekey;

import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

@Stateless
public class ManyTomanyWithCompositeKeyDemoBean {

	private static final Logger LOGGER = Logger.getLogger(ManyTomanyWithCompositeKeyDemoBean.class);
	
	@PersistenceContext(unitName = "JPADB")
	private EntityManager em;
	
	
	public void addPost(final String title, final String text) {
		Post post = new Post();
		post.setText(text);
		post.setTitle(title);
		em.persist(post);
		LOGGER.info("Post saved successfully with postId :: " + post.getPostId());
	}
	
	public void addTag(final String tag) {
		Tag tagEntity = new Tag();
		tagEntity.setTag(tag);
		em.persist(tagEntity);
		LOGGER.info("Tag saved successfully with postId :: " + tagEntity.getTagId());
	}
	
	public void addTagToPost(Integer tagId, Integer postId) {
		Tag tag = em.getReference(Tag.class, tagId);
		Post post = em.getReference(Post.class, postId);
		PostTag postTag = new PostTag(post, tag);
		postTag.setCreatedDate(Calendar.getInstance());
		postTag.setUpdatedDate(Calendar.getInstance());
		em.persist(postTag);
	}
	
	public void removeTagFromPost(Integer tagId, Integer postId) {
		Tag tag = em.getReference(Tag.class, tagId);
		Post post = em.getReference(Post.class, postId);
		PostTagId id = new PostTagId(post, tag);
		PostTag postTag = em.find(PostTag.class, id);
		em.remove(postTag);
	}
	
	public void getPostTags(Integer postId) {
		Post post = em.find(Post.class, postId);
		LOGGER.info("Tags for post with postId :: " + postId + " are :: ");
		post.getTags().stream().forEach(LOGGER::info);
	}
}

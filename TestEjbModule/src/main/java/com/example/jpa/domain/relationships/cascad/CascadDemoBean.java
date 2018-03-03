package com.example.jpa.domain.relationships.cascad;

import java.util.Calendar;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.*;
import org.apache.log4j.Logger;

@Stateless
@LocalBean
public class CascadDemoBean {

	private static final Logger LOGGER = Logger.getLogger(CascadDemoBean.class);

	@PersistenceContext(unitName = "JPADB")
	private EntityManager entityManager;

	// Without Cascad Persist we will have to add Post and PostDetails as below
	public void createPost(final String postName) {
		try {
			PostUsingCascad post = new PostUsingCascad();
			post.setName(postName);
			entityManager.persist(post);

			PostdetailsUsingCascad postdetails = new PostdetailsUsingCascad();
			postdetails.setCreatedDate(Calendar.getInstance());
			postdetails.setVisible(true);
			post.setPostdetails(postdetails);
			entityManager.persist(postdetails);
			
			TagUsingCascad tag = new TagUsingCascad();
			tag.setTag("One");
			post.addTag(tag);
			entityManager.persist(tag);
			
			TagUsingCascad tag1 = new TagUsingCascad();
			tag1.setTag("Two");
			post.addTag(tag1);
			entityManager.persist(tag1);
			
			LOGGER.info("Post saved successfully without cascad persist with postId :: " + post.getPostId() + " and postDetails Id :: "
					+ postdetails.getPostId());
		} catch (Exception e) {
			LOGGER.error("Error while saving post with cascad persist disabled :: " + e);
			e.printStackTrace();
		}
	}

	// With Cascad Persist we can add Post and PostDetails as below
	public void createPostWithCascadEnabled(final String postName) {
		try {
			PostUsingCascad post = new PostUsingCascad();
			post.setName(postName);

			PostdetailsUsingCascad postdetails = new PostdetailsUsingCascad();
			postdetails.setCreatedDate(Calendar.getInstance());
			postdetails.setVisible(true);
			post.setPostdetails(postdetails);
			
			TagUsingCascad tag = new TagUsingCascad();
			tag.setTag("One");
			
			TagUsingCascad tag1 = new TagUsingCascad();
			tag1.setTag("Two");
			
			post.addTag(tag);
			post.addTag(tag1);
			entityManager.persist(post);
			LOGGER.info("Post saved successfully with cascad enavled with postId :: " + post.getPostId() + " and postDetails Id :: "
					+ postdetails.getPostId());
		} catch (Exception e) {
			LOGGER.error("Error while saving post with persist cascad enabled :: " + e);
			e.printStackTrace();
		}
	}
	
	public void foo() {
		
	}
}

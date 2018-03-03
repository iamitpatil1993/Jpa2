package com.example.jpa.domain.relationships.collectionvalue.manytomany.extracolumns.compositekey;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManyToManyWithExtrColumnsWithCompositeKeyDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManyTomanyWithCompositeKeyDemoBean bean;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getParameter("method");
		Integer postId = null;
		Integer tagId = null;
		String postTitle = req.getParameter("postTitle");
		String postText = req.getParameter("postText");
		String tag = req.getParameter("tag");
		if (req.getParameter("postId") != null)
			postId = Integer.parseInt(req.getParameter("postId"));
		if (req.getParameter("tagId") != null)
			tagId = Integer.parseInt(req.getParameter("tagId"));
		switch (method) {
		case "addPost":
			bean.addPost(postTitle, postText);
			break;
		case "addTag":
			bean.addTag(tag);
			break;
		case "addTagToPost":
			bean.addTagToPost(tagId, postId);
			break;
		case "removeTagFromPost":
			bean.removeTagFromPost(tagId, postId);
			break;
		case "getPostTags":
			bean.getPostTags(postId);
			break;
		default:
			resp.getWriter().println("Invalid option :: " + method);
		}
	}
}

package com.ktdsuniversity.edu.board;

public class Post {

	private int postIndex;
	private String title;
	private String postWriter;
	private String postDate;
	private int hits;
	private String postContent;
	private Comment[] comment;
	private boolean isDeleted;
	
	public Post(int postIndex, String title, String postWriter, String postDate, int hits, String postContent, Comment[] comment, boolean isDeleted) {
		this.postIndex = postIndex;
		this.title = title;
		this.postWriter = postWriter;
		this.postDate = postDate;
		this.hits = hits;
		this.postContent = postContent;
		this.comment = comment;
		this.isDeleted = isDeleted;
	}
	
	public int getPostIndex() {
		return postIndex;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getPostWriter() {
		return postWriter;
	}
	
	public String getPostDate() {
		return postDate;
	}
	
	public int getHits() {
		return hits;
	}
	
	public String getPostContent() {
		return postContent;
	}
	
	public Comment[] getComment() {
		return comment;
	}
	
	private boolean getIsDeleted() {
		return isDeleted;
	}
}

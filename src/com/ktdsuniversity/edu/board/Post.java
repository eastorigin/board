package com.ktdsuniversity.edu.board;

public class Post {

	private int postIndex;
	private String title;
	private String postWriter;
	private String postDate;
	private int hits;
	private String postContent;
	private Comment[] comments;
	private boolean isDeleted;
	
	public Post(int postIndex, String title, String postWriter, String postDate, int hits, String postContent, Comment[] comment, boolean isDeleted) {
		this.postIndex = postIndex;
		this.title = title.trim();
		this.postWriter = postWriter;
		this.postDate = postDate;
		this.hits = hits;
		this.postContent = postContent;
		this.comments = new Comment[10];
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
		return comments;
	}
	
	boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void addComment(Comment newComment) {
		for(int i = 0; i < comments.length; i++) {
			if(comments[i] == null) {
				comments[i] = newComment;
				return;
			}
		}
		System.out.println("댓글을 10개 초과햐여 등록할 수 없습니다");
	}
	
	public void increaseHits() {
		this.hits++;
	}
	
	public void deletePost() {
		this.isDeleted = true;
	}
	
	public void editPost(String newTitle, String newPostContent) {
		this.title = newTitle.trim();
		this.postContent = newPostContent;
	}
}

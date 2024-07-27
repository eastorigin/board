package com.ktdsuniversity.edu.board;

public class Comment {

	private int commentIndex;
	private String commentContent;
	private String commentWriter;
	private String commentDate;
	
	public Comment (int commentIndex, String commentContent, String commentWriter, String commentDate) {
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.commentIndex = commentIndex;
		this.commentWriter = commentWriter;
	}
	
	public int getCommentIndex() {
		return commentIndex;
	}
	
	public String getCommentContent() {
		return commentContent;
	}
	
	public String getCommentWriter() {
		return commentWriter;
	}
	
	public String getCommentDate() {
		return commentDate;
	}
}

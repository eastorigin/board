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
}

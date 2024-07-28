package com.ktdsuniversity.edu.board;

public interface BoardInterface {

	public void addPost(String title, String writer, String date, String content);
	public void printAllPosts();
	public void printPost(int index);
	public void editPost(int index, Post post);
	public void deletePost(int index);
	public void addComment(int index, Comment comment);
	public int countPosts();
	
}

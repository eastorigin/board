package com.ktdsuniversity.edu.board;

public interface BoardInterface {

	public void addPost(String title, String writer, String date, String content);
	public void printAllPosts();
	public void printPost(int index);
	public void editPost(int index, Post post);
	public void deletePost(int id);
	public void addComment(int index, Comment comment);
	public int countPosts();
	
}

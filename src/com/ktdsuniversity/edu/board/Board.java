package com.ktdsuniversity.edu.board;

public class Board implements BoardInterface{
	
	private static final int MAX_POSTS = 1000;
	private Post[] posts;
	private int postIndex;
	private int postCount;
	
	public Board() {
		posts = new Post[MAX_POSTS];
		this.postIndex = postIndex;
		this.postCount = postCount;
	}
	
	@Override
	public void addPost(String title, String writer, String date, String content) {
		if(postCount > MAX_POSTS) {
			System.out.println("게시글은 1000개 초과할 수 없습니다");
			return;
		}
		
		if(title == null || title.trim().isEmpty() || title.length() >30) {
			System.out.println("게시글 제목을 입력해주세요. (단, 30글자 이내)");
		}
		
		Post post = new Post(postIndex++, title, writer, date, 0, content, null, false);
		posts[postCount++] = post;
	}
	
	@Override
	public void printAllPosts() {
		for(int i = 0; i < postIndex; i++) {
			if(posts[i] != null && !posts[i].getIsDeleted()) {
				int commentCount = 0;
				Comment[] comments = posts[i].getComment();
				for(int j = 0; j < comments.length; j++) {
					if(comments[j] != null) {
						commentCount++;
					}
				}
				System.out.println("제목: " + posts[i].getTitle() + ", 댓글 수: " + commentCount);
			}
		}
	}
	
	@Override
	public void printPost(int index) {
		
	}

}

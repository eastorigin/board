package com.ktdsuniversity.edu.board;

public class Board implements BoardInterface{
	
	private static final int MAX_POSTS = 1000;
	private Post[] posts;
	private int postsIndex;
	private int postCount;
	
	public Board() {
		posts = new Post[MAX_POSTS];;
	}
	
	public Post[] getPosts() {
		return posts;
	}
	
	public int getPostsIndex() {
		return postsIndex;
	}
	
	public int getPostCount() {
		return postCount;
	}
	
	@Override
	public void addPost(String title, String writer, String date, String content) {
		if(postCount > MAX_POSTS) {
			System.out.println("게시글은 1000개 초과할 수 없습니다");
			return;
		}
		
		if(title == null || title.trim().isEmpty() || title.length() >30) {
			System.out.println("게시글 제목을 입력해주세요. (단, 30글자 이내)");
			return;
		}
		
		Post post = new Post(postsIndex++, title, writer, date, 0, content, null, false);
		posts[postCount++] = post;
	}
	
	@Override
	public void printAllPosts() {
		for(int i = 0; i < postsIndex; i++) {
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
		for (int i = 0; i < this.postsIndex; i++) {
			if (posts[i] != null && posts[i].getPostIndex() == index) {
				if (posts[i].getIsDeleted()) {
					System.out.println("삭제된 게시글입니다");
				}else {
					posts[i].increaseHits();
					System.out.println("Index: " + posts[i].getPostIndex());
					System.out.println("제목: " + posts[i].getTitle());
					System.out.println("작성자: " + posts[i].getPostWriter() + ", " + posts[i].getPostDate());
					System.out.println("조회 수: " +posts[i].getHits());
					System.out.println("내용: " + posts[i].getPostContent());
					Comment[] comments = posts[i].getComment();
					for (int j = 0; j < comments.length; j++) {
						if(comments[j] != null) {
							System.out.println("Index: " + comments[j].getCommentIndex() + ", 작성자: " + comments[j].getCommentWriter());
							System.out.println("작성자: " + comments[j].getCommentWriter() + ", 날짜: " + comments[j].getCommentDate());
						}
					}
				}
				return;
			}
		}
		System.out.println("해당 Index의 게시글이 없습니다");
	}
	
	@Override
	public void editPost(int index, Post post) {
		for(int i = 0; i < this.postsIndex; i++) {
			if(posts[i] != null && posts[i].getPostIndex() == index) {
				if(posts[i].getIsDeleted()) {
					System.out.println("삭제된 게시글은 수정할 수 없습니다");
					return;
				}
				posts[i].editPost(post.getTitle(), post.getPostContent());
				System.out.println("게시글 수정 완료");
				return;
			}
		}
		System.out.println("해당 Index의 게시글이 존재하지 않습니다");
	}
	
	@Override
	public void deletePost(int index) {
		for(int i = 0; i < this.postsIndex; i++) {
			if(posts[i] != null && posts[i].getPostIndex() == index) {
				posts[i].deletePost();
				postCount--;
				System.out.println("게시글 삭제 완료");
				return;
			}
		}
		System.out.println("해당 Index의 게시글이 존재하지 않습니다");
	}
	
	@Override
	public int countPosts() {
		return postCount;
	}
	
	@Override
	public void addComment(int index, Comment comment) {
		for (int i = 0; i < this.postsIndex; i++) {
			if(posts[i] != null && posts[i].getPostIndex() == index) {
				if(posts[i].getIsDeleted()) {
					System.out.println("삭제된 게시글에는 댓글을 작성할 수 없습니다");
					return;
				}
			}
			posts[i].addComment(comment);
			return;
		}
		System.out.println("해당 Index의 게시글이 존재하지 않습니다");
	}

}

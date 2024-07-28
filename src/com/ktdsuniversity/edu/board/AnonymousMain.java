package com.ktdsuniversity.edu.board;

import java.util.Scanner;

public class AnonymousMain {

	public static void main(String[] args) {
		BoardInterface board = new BoardInterface() {
			private static final int MAX_POSTS = 1000;
			private Post[] posts = new Post[MAX_POSTS];
			private int postsIndex;
			private int postCount;
			
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
		};
		
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		
		while(number != 8) {
			System.out.println("게시판에 입장하였습니다");
			System.out.println("1 ~ 8 중 원하는 기능의 숫자를 입력하세요.");
			System.out.println("1. 게시글 작성하기");
			System.out.println("2. 모든 게시글 출력하기");
			System.out.println("3. 게시글 번호로 게시글 정보 출력하기");
			System.out.println("4. 게시글 수정하기");
			System.out.println("5. 게시글 삭제하기");
			System.out.println("6. 게시판에 등록된 게시글의 개수 출력하기");
			System.out.println("7. 게시글에 댓글 작성하기");
			System.out.println("8. 게시판 나가기");
			
			number = scanner.nextInt();
			scanner.nextLine();
			
			if (number == 1) {
				System.out.println("게시글 제목을 입력하세요");
				String titile = scanner.nextLine();
				System.out.println("게시글 작성자를 입력하세요");
				String writer = scanner.nextLine();
				System.out.println("게시글 작성 날짜를 입력하세요");
				String date = scanner.nextLine();
				System.out.println("게시글 내용을 입력하세요");
				String content = scanner.nextLine();
				board.addPost(titile, writer, date, content);
			}else if(number == 2) {
				board.printAllPosts();
			}else if(number == 3) {
				System.out.println("게시글 index를 입력하세요");
				int postIndex = scanner.nextInt();
				board.printPost(postIndex);
			}else if(number == 4) {
				System.out.println("게시글 index 번호를 입력하세요");
				int postIndex = scanner.nextInt();
				scanner.nextLine();
				System.out.println("수정할 게시글 제목을 입력하세요");
				String title = scanner.nextLine();
				System.out.println("수정할 게시글 내용을 입력하세요");
				String content = scanner.nextLine();
				
				Post beforePost = null;
				
				// 오류 어떻게 수정해야 하는지 모르겠음.
				for(int i = 0; i < board.getPostsIndex(); i++) {
					if(board.getPosts()[i] != null && board.getPosts()[i].getPostIndex() == postIndex) {
						beforePost = board.getPosts()[i];
						break;
					}
				}

				if (beforePost != null) {
					Post editPost = new Post(beforePost.getPostIndex(), title, beforePost.getPostWriter(), beforePost.getPostDate(), beforePost.getHits(), content, beforePost.getComment(), beforePost.getIsDeleted());
					board.editPost(postIndex, editPost);
				}else {
					System.out.println("해당 Index의 게시글이 없습니다");
				}
			}else if(number == 5) {
				System.out.println("게시글 Index를 입력하세요");
				int postIndex = scanner.nextInt();
				board.deletePost(postIndex);
			}else if(number == 6) {
				System.out.println("총 게시글 개수: " + board.countPosts());
			}else if(number == 7) {
				System.out.println("게시글 Index를 입력하세요.");
				int postIndex = scanner.nextInt();
				scanner.nextLine();
				System.out.println("댓글 내용을 입력하세요");
				String commentContent = scanner.nextLine();
				System.out.println("댓글 작성자를 입력하세요");
				String commentWriter = scanner.nextLine();
				System.out.println("댓글 작성 날짜를 입력하세요");
				String commentDate = scanner.nextLine();
				Comment comment = new Comment(postIndex, commentContent, commentWriter, commentDate);
				board.addComment(postIndex, comment);
			}else if(number == 8) {
				System.out.println("게시판을 나갑니다");
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
			
		}
	}
}

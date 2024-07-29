package com.ktdsuniversity.edu.board;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
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
				String title = scanner.nextLine();
				System.out.println("게시글 작성자를 입력하세요");
				String writer = scanner.nextLine();
				System.out.println("게시글 작성 날짜를 입력하세요");
				String date = scanner.nextLine();
				System.out.println("게시글 내용을 입력하세요");
				String content = scanner.nextLine();
				board.addPost(title, writer, date, content);
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

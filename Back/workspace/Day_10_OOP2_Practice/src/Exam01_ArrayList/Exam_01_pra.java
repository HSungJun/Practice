package Exam01_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_01_pra {

	// public static int searchByTitle(String title) {
	//
	//
	// }

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();

		while (true) {
			System.out.println("<< Netflix Simulator >>");
			System.out.println("1. 신규 영화 등록");
			System.out.println("2. 영화 목록 출력");
			System.out.println("3. 영화 목록 검색 (제목으로 검색)");
			System.out.println("4. 영화 목록 수정 (제목으로 검색)");
			System.out.println("5. 영화 삭제 (제목으로 검색)");
			System.out.println("0. 종료");
			System.out.print(">>>");

			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
//					if(movie[index]==null) {
//					System.out.println("제목을 입력해주세요. ");
//					String tit = sc.nextLine();
//					System.out.println("장르를 입력해주세요. ");
//					String gen = sc.nextLine();
//					System.out.println("별점을 입력해주세요. ");
//					double sco = Double.parseDouble(sc.nextLine());

				manager.addMovie(new Movie("아바타2", "SF", 8));
				manager.addMovie(new Movie("범죄도시2", "느와르", 8));
				manager.addMovie(new Movie("나홀로2", "코믹", 8));

//					manager.addMovie(new Movie(tit, gen, sco));
//						System.out.println());
//						index++;

				// movie[index]++ = new Movie(tit, gen, sco); 일시 if 필요없음.

//					}else {
//						if(movie[index]!=null) {
//							System.out.println("목록이 가득 찼습니다. 목록을 삭제해주세요.");
//						}
//					}

			} else if (menu == 2) {
//					if(movie[0]==null) {
//						System.out.println("영화가 없습니다.");
//						break;
//					}else {
//						System.out.println("영화 이름\t장르\t평점");
//						for (int i = 0; movie[i] != null; i++) {
//							System.out.println(movie[i].getTitle()+
//									"\t"+movie[i].getGenre()+"\t"+movie[i].getScore());
//						}
//					} 
//					System.out.println();

				ArrayList<Movie> movies = manager.getMovie();
				System.out.println("영화 이름\t장르\t평점");
				for (Movie m : movies) {
					System.out.println(m.getTitle() + "\t" + m.getGenre() + "\t" + m.getScore());
				}

			} else if (menu == 3) {
				System.out.print("검색할 영화 제목 : ");
				String title = sc.nextLine();

				System.out.println("영화 이름\t장르\t평점");

//					ArrayList<Movie> movies = manager.getMovie();
				ArrayList<Movie> movies = manager.seartchTitle(title);
				if (movies.size() == 0) {
					System.out.println("해당제목의 영화는 존재하지 않습니다.");
				} else {
					for (Movie m : movies) {

						System.out.println(m.getTitle() + "\t" + m.getGenre() + "\t" + m.getScore());

					}
				}
			} else if (menu == 4) {

				System.out.print("수정할 영화 제목: ");
				String title = sc.nextLine();
				ArrayList<Movie> movies = manager.getMovie();
				int index = manager.getIndexByTitle(title);

				if (index == 1) {
					System.out.println("해당 제목의 영화는 존재하지 않습니다.");
				} else {

					System.out.print("변경할 제목 : ");
					String updateTitle = sc.nextLine();

					System.out.print("변경할 장르 : ");
					String updateGenre = sc.nextLine();

					System.out.print("변경할 평점 : ");
					double updateScore = Double.parseDouble(sc.nextLine());

					manager.updateByIndex(index, new Movie(updateTitle, updateGenre, updateScore));

					
				}

			} else if (menu == 5) {

				System.out.print("삭제할 영화 제목 : ");
				String title = sc.nextLine();

				int result = manager.removeMovie(title);
				if (result == -1) {
					System.out.println("삭제하려는 영화가 존재하지 않습니다.");
				}

//					System.out.print("삭제할 영화 제목 : ");
//					String title = sc.nextLine();
//
//					for(int i = 0; i < index; i++) {
//						if(movie[i].getTitle().equals(title)) {
//
//							for(int j = i; j<movie.length; j++) {
//								if(j == index -1) {
//									movie[j] = null;
//									index--;
//									break;
//								}
//								movie[j] = movie [j+1];
//							}
//							break;
//						}
//					}

//					int del = 0;
//					for (index=0; index < movie.length; index++) {
//						if(movie[index]==null) {
//							System.out.println("영화가 없습니다.");
//							break;
//						}
//						else if(movie[index]!=null) {
//							System.out.println((index+1)+"\t" + movie[index].getTitle()+
//									"\t\t"+movie[index].getGenre()+"\t"+movie[index].getScore());
//
//							System.out.println("삭제할 영화의 번호를 고르세요.");
//
//							del = Integer.parseInt(sc.nextLine());
//
//							if (del <= movie.length) {
//								movie[del-1] = null;
//								System.out.println(del + "번째를 삭제하였습니다. ");
//							}
//						}
//					}	

			} else if (menu == 0) {
				System.out.println("Netflix 를 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
				continue;
		}
	}
}

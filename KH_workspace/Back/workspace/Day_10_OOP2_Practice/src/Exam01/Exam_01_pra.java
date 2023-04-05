package Exam01;

import java.util.Scanner;

public class Exam_01_pra {

	//	public static int searchByTitle(String title) {
	//		
	//		
	//	}


	public static void main(String[] args) {


		
		Scanner sc = new Scanner(System.in);
		int index = 0;
		Movie[] movie = new Movie[10];
		

		while (true) {
			System.out.println("<< Netflix Simulator >>");
			System.out.println("1. 신규 영화 등록");
			System.out.println("2. 영화 목록 출력");
			System.out.println("3. 영화 목록 검색");
			System.out.println("4. 영화 목록 수정");
			System.out.println("5. 영화 삭제");
			System.out.println("0. 종료");
			System.out.print(">>>");

			int menu = Integer.parseInt(sc.nextLine());

			try {
				if (menu==1) {
					if(movie[index]==null) {
						System.out.println("제목을 입력해주세요. ");
						String tit = sc.nextLine();
						System.out.println("장르를 입력해주세요. ");
						String gen = sc.nextLine();
						System.out.println("별점을 입력해주세요. ");
						double sco = Double.parseDouble(sc.nextLine());
						movie[index] = new Movie (tit, gen, sco);
						System.out.println(movie[index].getTitle()+"\t"+
								movie[index].getGenre()+"\t"+movie[index].getScore());
						index++;

						//movie[index]++ = new Movie(tit, gen, sco); 일시 if 필요없음.
						
					}else {
						if(movie[index]!=null) {
							System.out.println("목록이 가득 찼습니다. 목록을 삭제해주세요.");
						}
					}

				}else if (menu == 2) {
					if(movie[0]==null) {
						System.out.println("영화가 없습니다.");
						break;
					}else {
						System.out.println("영화 이름\t장르\t평점");
						for (int i = 0; movie[i] != null; i++) {
							System.out.println(movie[i].getTitle()+
									"\t"+movie[i].getGenre()+"\t"+movie[i].getScore());
						}
					} 
					System.out.println();

				}
				else if (menu == 3) {
					System.out.print("검색할 영화 제목 : ");
					String title = sc.nextLine();

					System.out.println("영화 이름\t\t장르\t평점");
					for (int i = 0; i<index; i++) {
						if(movie[i].getTitle().equals(title))
							System.out.println(movie[i].getTitle()+
									"\t"+movie[i].getGenre()+"\t"+movie[i].getScore());
					}

				}else if (menu == 4) {
					System.out.print("수정할 영화 제목 : ");
					String title = sc.nextLine();

					for (int i = 0; i<index; i++) {
						if(movie[i].getTitle().equals(title)) {
							System.out.print("변경할 제목 : ");
							String updateTitle = sc.nextLine();

							System.out.print("변경할 장르 : ");
							String updateGenre = sc.nextLine();

							System.out.print("변경할 평점 : ");
							double updateScore = Double.parseDouble(sc.nextLine());
							//						
							movie[i] = new Movie(updateTitle, updateGenre, updateScore);

							System.out.println(movie[i].getTitle()+
									"\t"+movie[i].getGenre()+"\t"+movie[i].getScore());
							break;
						}
					}
				}else if (menu == 5) {

					System.out.print("삭제할 영화 제목 : ");
					String title = sc.nextLine();

					for(int i = 0; i < index; i++) {
						if(movie[i].getTitle().equals(title)) {

							for(int j = i; j<movie.length; j++) {
								if(j == index -1) {
									movie[j] = null;
									index--;
									break;
								}
								movie[j] = movie [j+1];
							}
							break;
						}
					}


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

				}else if (menu == 0) {
					System.out.println("Netflix 를 종료합니다.");
					System.exit(0);
				}else  {
					System.out.println("잘못 입력하셨습니다.");
					break;
				}
			}catch (Exception e) {
				System.out.println("메뉴를 잘못 입력하셨습니다.");
			}
		}
	}
}
package Exam01;

import java.util.Scanner;

public class Movie_teacher {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Movie movie = null;
		
		while(true) {
			System.out.println("<< Netflix Simulator >>");
			System.out.println("1. 신규 영화 등록");
			System.out.println("2. 영화 목록 출력");
			System.out.println("0. 종료");
			System.out.print(">>>");
			int menu = Integer.parseInt(sc.nextLine());
			
			if (menu==1) {
				System.out.println("제목을 입력해주세요. ");
				String tit = sc.nextLine();
				
				System.out.println("장르를 입력해주세요. ");
				String gen = sc.nextLine();
				
				System.out.println("별점을 입력해주세요. ");
				double sco = Double.parseDouble(sc.nextLine());
				
				movie = new Movie(tit, gen, sco);
			}
		}
		
	}
	
}

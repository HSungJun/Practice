package Exam01;

import java.util.Scanner;

public class Movie {

	
	
	private String title;
	private String genre;
	private double score;


//	public Movie() {}
	public Movie(String title, String genre, double score) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("������ �Է��ϼ��� : ");
//		this.title = sc.nextLine();
//		System.out.println();
//		System.out.print("�帣�� �Է��ϼ��� : ");
//		this.genre = sc.nextLine();
//		System.out.println();
//		System.out.print("������ �Է��ϼ��� : ");
//		this.score = sc.nextDouble();
//		System.out.println();
		
		
		
		
		this.title=title;
		this.genre=genre;	
		this.score=score;
		
	}
		
		
	
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		if (score >= 0 || score <= 10) {
			this.score = score;
		}else {System.out.println("�߸��Է��ϼ̽��ϴ�");}

	}
}

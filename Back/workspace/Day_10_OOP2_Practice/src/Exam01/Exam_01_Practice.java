package Exam01;

import java.util.Scanner;

public class Exam_01_Practice {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int i = 0;
		
		Movie[] movie = new Movie[100];

		while (true) {
			System.out.println("<< Netflix Simulator >>");
			System.out.println("1. �ű� ��ȭ ���");
			System.out.println("2. ��ȭ ��� ���");
			System.out.println("0. ����");
			System.out.print(">>>");

			int menu = Integer.parseInt(sc.nextLine());


			if (menu==1) {
				if(movie[i]==null) {
				System.out.println("������ �Է����ּ���. ");
				String tit = sc.nextLine();
				System.out.println("�帣�� �Է����ּ���. ");
				String gen = sc.nextLine();
				System.out.println("������ �Է����ּ���. ");
				double sco = Double.parseDouble(sc.nextLine());
				movie[i] = new Movie (tit, gen, sco);
				System.out.println(movie[i].getTitle()+"\t"+movie[i].getGenre()+"\t"+movie[i].getScore());
				i++;
				
				}
			}else if (menu == 2) {
				for(i=0; i<movie.length; i++) {
					if(movie[i] == null) {
						System.out.println("��ȭ�� �����ϴ�.");
						break;
					}else {
						
						
						System.out.println(movie[i].getTitle()+"\t"+movie[i].getGenre()+"\t"+movie[i].getScore());
					} 
				}
			}else if (menu == 0) {
				System.out.println("Netflix �� �����մϴ�.");
				System.exit(0);
			}else  {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			continue;
		}
	}
}

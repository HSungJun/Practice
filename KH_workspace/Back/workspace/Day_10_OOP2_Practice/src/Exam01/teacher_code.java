package Exam01;

import java.util.Scanner;

public class teacher_code {
	public static void main(String[] args) {

		// ������ ����
		// ���ټ��� ������ ���̵��� ���� ���� 
		// MVC ����
		// M V C 
		// Modeling Vie Control
		// Model 	- �ð������� �������� ������ ���������� �����ϴ� �ڵ�
		// View		- ����ڿ� ���� ���۵ǰ� �������� �κ�
		// Control	- ���� �� �б���� �ڵ�

		//Refactoring - ¥���� �ִ� �ڵ带 ������ �з���.
		


		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		//�Ŵ����� �������μ� manager ���ο� movie[]��¥�� �迭�� ������.


		while (true) {
			System.out.println("<< Netflix Simulator >>");
			System.out.println("1. �ű� ��ȭ ���");
			System.out.println("2. ��ȭ ��� ���");
			System.out.println("3. ��ȭ ��� �˻�");
			System.out.println("4. ��ȭ ��� ����");
			System.out.println("5. ��ȭ ����");
			System.out.println("0. ����");
			System.out.print(">>>");
			int menu = Integer.parseInt(sc.nextLine());


			
				if (menu==1) {
					//if(movie[index]==null) {
					System.out.println("������ �Է����ּ���. ");
					String tit = sc.nextLine();
					System.out.println("�帣�� �Է����ּ���. ");
					String gen = sc.nextLine();
					System.out.println("������ �Է����ּ���. ");
					double sco = Double.parseDouble(sc.nextLine());

					//movie[index]++ = new Movie(tit, gen, sco); �Ͻ� if �ʿ����.

					manager.addMovie(new Movie(tit, gen, sco));
					// �Ŵ��� addmovie �� �Է¹������� index�� ���� +1 ����



					//					}else {
					//						if(movie[index]!=null) {
					//							System.out.println("����� ���� á���ϴ�. ����� �������ּ���.");
					//						}
				}else if (menu == 2) {
					Movie[] movie = manager.getMovie();

					System.out.println("��ȭ �̸�\t�帣\t����");
					for(int i = 0; i<manager.getIndex(); i++){
						System.out.println(movie[i].getTitle()+"\t"+
								movie[i].getGenre()+"\t"+
								movie[i].getScore());
					}
				}else if (menu == 3) {

				}else if (menu == 4) {

				}else if (menu == 5) {

				}
				//					int del = 0;
				//					for (index=0; index < movie.length; index++) {
				//						if(movie[index]==null) {
				//							System.out.println("��ȭ�� �����ϴ�.");
				//							break;
				//						}
				//						else if(movie[index]!=null) {
				//							System.out.println((index+1)+"\t" + movie[index].getTitle()+
				//									"\t\t"+movie[index].getGenre()+"\t"+movie[index].getScore());
				//
				//							System.out.println("������ ��ȭ�� ��ȣ�� ��������.");
				//
				//							del = Integer.parseInt(sc.nextLine());
				//
				//							if (del <= movie.length) {
				//								movie[del-1] = null;
				//								System.out.println(del + "��°�� �����Ͽ����ϴ�. ");
				//							}
				//						}
				//					}	

				else if (menu == 0) {
					System.out.println("Netflix �� �����մϴ�.");
					System.exit(0);
				}
			
		}
	}
}
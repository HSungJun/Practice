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
			System.out.println("1. �ű� ��ȭ ���");
			System.out.println("2. ��ȭ ��� ���");
			System.out.println("3. ��ȭ ��� �˻�");
			System.out.println("4. ��ȭ ��� ����");
			System.out.println("5. ��ȭ ����");
			System.out.println("0. ����");
			System.out.print(">>>");

			int menu = Integer.parseInt(sc.nextLine());

			try {
				if (menu==1) {
					if(movie[index]==null) {
						System.out.println("������ �Է����ּ���. ");
						String tit = sc.nextLine();
						System.out.println("�帣�� �Է����ּ���. ");
						String gen = sc.nextLine();
						System.out.println("������ �Է����ּ���. ");
						double sco = Double.parseDouble(sc.nextLine());
						movie[index] = new Movie (tit, gen, sco);
						System.out.println(movie[index].getTitle()+"\t"+
								movie[index].getGenre()+"\t"+movie[index].getScore());
						index++;

						//movie[index]++ = new Movie(tit, gen, sco); �Ͻ� if �ʿ����.
						
					}else {
						if(movie[index]!=null) {
							System.out.println("����� ���� á���ϴ�. ����� �������ּ���.");
						}
					}

				}else if (menu == 2) {
					if(movie[0]==null) {
						System.out.println("��ȭ�� �����ϴ�.");
						break;
					}else {
						System.out.println("��ȭ �̸�\t�帣\t����");
						for (int i = 0; movie[i] != null; i++) {
							System.out.println(movie[i].getTitle()+
									"\t"+movie[i].getGenre()+"\t"+movie[i].getScore());
						}
					} 
					System.out.println();

				}
				else if (menu == 3) {
					System.out.print("�˻��� ��ȭ ���� : ");
					String title = sc.nextLine();

					System.out.println("��ȭ �̸�\t\t�帣\t����");
					for (int i = 0; i<index; i++) {
						if(movie[i].getTitle().equals(title))
							System.out.println(movie[i].getTitle()+
									"\t"+movie[i].getGenre()+"\t"+movie[i].getScore());
					}

				}else if (menu == 4) {
					System.out.print("������ ��ȭ ���� : ");
					String title = sc.nextLine();

					for (int i = 0; i<index; i++) {
						if(movie[i].getTitle().equals(title)) {
							System.out.print("������ ���� : ");
							String updateTitle = sc.nextLine();

							System.out.print("������ �帣 : ");
							String updateGenre = sc.nextLine();

							System.out.print("������ ���� : ");
							double updateScore = Double.parseDouble(sc.nextLine());
							//						
							movie[i] = new Movie(updateTitle, updateGenre, updateScore);

							System.out.println(movie[i].getTitle()+
									"\t"+movie[i].getGenre()+"\t"+movie[i].getScore());
							break;
						}
					}
				}else if (menu == 5) {

					System.out.print("������ ��ȭ ���� : ");
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

				}else if (menu == 0) {
					System.out.println("Netflix �� �����մϴ�.");
					System.exit(0);
				}else  {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					break;
				}
			}catch (Exception e) {
				System.out.println("�޴��� �߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
}
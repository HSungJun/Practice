package Exam02;

import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();


		while(true) {
			System.out.println("<< Cafe H >>");
			System.out.println("1. �޴��߰�");
			System.out.println("2. �޴����");
			int menu = Integer.parseInt(sc.nextLine());

			if(menu==1) {
				System.out.print("���� ��ȣ : ");
				int num = Integer.parseInt(sc.nextLine());

				System.out.print("���� �̸� : ");
				String name = sc.nextLine();

				System.out.print("���� : ");
				int price = Integer.parseInt(sc.nextLine());

				manager.addMenu(new CafeMenu(num,name,price));
 
			}else if(menu==2) {
				CafeMenu[] cafe = manager.getMenu();

				System.out.println("��ȣ\t�̸�\t����");
				for(int i=0; i<manager.getIndex(); i++) {
					System.out.println(cafe[i].getNum() +"\t"+
							cafe[i].getName()+"\t"+
							cafe[i].getPrice());
				}

			}	
		}

		//		CafeMenu Am = new CafeMenu(1001, "Americano" ,2500);
		//		
		//		System.out.println("��ǰ��ȣ : " + Am.getNum()
		//		+"\t" + " ��ǰ�� : " + Am.getName()
		//		+"\t" +" ���� : " + Am.getPrice());
		//		
		//		CafeMenu La = new CafeMenu(1002, "CafeLatte" ,3000);
		//		
		//		System.out.println("��ǰ��ȣ : " + La.getNum()
		//		+"\t" + " ��ǰ�� : " + La.getName()
		//		+"\t" +" ���� : " + La.getPrice());


	}
}

package Exam02_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();


		while(true) {
			System.out.println("<< Cafe H >>");
			System.out.println("1. �޴� �߰�");
			System.out.println("2. �޴� ���");
			System.out.println("3. �޴� �˻� (�޴� ��ȣ�� �˻�)");
			System.out.println("4. �޴� ���� (�޴� ��ȣ�� �˻�)");
			System.out.println("5. �޴� ���� (�޴� ��ȣ�� �˻�)");
			int HomeMenu = Integer.parseInt(sc.nextLine());

			if(HomeMenu==1) {
				System.out.print("���� ��ȣ : ");
				int num = Integer.parseInt(sc.nextLine());

				System.out.print("���� �̸� : ");
				String name = sc.nextLine();

				System.out.print("���� : ");
				int price = Integer.parseInt(sc.nextLine());

				manager.addMenu(new CafeMenu(num,name,price));
 
			}else if(HomeMenu==2) {
				ArrayList<CafeMenu> menus = manager.getMenu();

				System.out.println("�޴���ȣ\t�̸�\t����");
				for(CafeMenu menu : menus) {
					System.out.println(menu.getNum()+"\t"+
							menu.getName()+"\t"+
							menu.getPrice());
				}

			}else if (HomeMenu==3) {
				System.out.print("�˻��� ���� ��ȣ : ");
				int num = Integer.parseInt(sc.nextLine());
				
				
				System.out.println("�޴���ȣ\t�̸�\t����");
				
				
				ArrayList<CafeMenu> menus = manager.searchByNum(num);
				for (CafeMenu menu : menus) {
					
				System.out.println( menu.getNum() +"\t"+
						menu.getName() +"\t"+
						menu.getPrice());
				}
				
				
				
			}else if (HomeMenu ==4) {
				System.out.println("������ �޴� ��ȣ: ");
				int num = Integer.parseInt(sc.nextLine());
				
				ArrayList<CafeMenu> menus = manager.searchByNum(num);
				System.out.println("������ ��ȣ");
				int upNum = Integer.parseInt(sc.nextLine());
				
				System.out.println("������ �޴� �̸�");
				String upName= sc.nextLine();
				
				System.out.println("������ ����");
				int upPrice = Integer.parseInt(sc.nextLine());
				
				manager.updateByNum(num, new CafeMenu (upNum,upName,upPrice));
				
			}else if (HomeMenu ==5) {
				
				
				
			}
			
		}
		
	}
}

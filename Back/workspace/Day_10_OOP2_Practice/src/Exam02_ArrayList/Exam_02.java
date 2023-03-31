package Exam02_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();


		while(true) {
			System.out.println("<< Cafe H >>");
			System.out.println("1. 메뉴 추가");
			System.out.println("2. 메뉴 목록");
			System.out.println("3. 메뉴 검색 (메뉴 번호로 검색)");
			System.out.println("4. 메뉴 수정 (메뉴 번호로 검색)");
			System.out.println("5. 메뉴 삭제 (메뉴 번호로 검색)");
			int HomeMenu = Integer.parseInt(sc.nextLine());

			if(HomeMenu==1) {
				System.out.print("음료 번호 : ");
				int num = Integer.parseInt(sc.nextLine());

				System.out.print("음료 이름 : ");
				String name = sc.nextLine();

				System.out.print("가격 : ");
				int price = Integer.parseInt(sc.nextLine());

				manager.addMenu(new CafeMenu(num,name,price));
 
			}else if(HomeMenu==2) {
				ArrayList<CafeMenu> menus = manager.getMenu();

				System.out.println("메뉴번호\t이름\t가격");
				for(CafeMenu menu : menus) {
					System.out.println(menu.getNum()+"\t"+
							menu.getName()+"\t"+
							menu.getPrice());
				}

			}else if (HomeMenu==3) {
				System.out.print("검색할 음료 번호 : ");
				int num = Integer.parseInt(sc.nextLine());
				
				
				System.out.println("메뉴번호\t이름\t가격");
				
				
				ArrayList<CafeMenu> menus = manager.searchByNum(num);
				for (CafeMenu menu : menus) {
					
				System.out.println( menu.getNum() +"\t"+
						menu.getName() +"\t"+
						menu.getPrice());
				}
				
				
				
			}else if (HomeMenu ==4) {
				System.out.println("수정할 메뉴 번호: ");
				int num = Integer.parseInt(sc.nextLine());
				
				ArrayList<CafeMenu> menus = manager.searchByNum(num);
				System.out.println("변경할 번호");
				int upNum = Integer.parseInt(sc.nextLine());
				
				System.out.println("변경할 메뉴 이름");
				String upName= sc.nextLine();
				
				System.out.println("변경할 가격");
				int upPrice = Integer.parseInt(sc.nextLine());
				
				manager.updateByNum(num, new CafeMenu (upNum,upName,upPrice));
				
			}else if (HomeMenu ==5) {
				
				
				
			}
			
		}
		
	}
}

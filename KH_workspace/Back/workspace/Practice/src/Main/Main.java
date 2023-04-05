package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Gold;
import Classes.Member;
import Classes.Ruby;
import Classes.Silver;
import Manager.Manager;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		
		
		System.out.println("=== ȸ������ �ý��� ===");
		System.out.println("1. �ű�ȸ�� ���"); 
		System.out.println("2. ȸ�� ���� ���");
		System.out.println("0. ����");
		System.out.println(">>");

		while (true) {
			int menu = Integer.parseInt(sc.nextLine());
			
			if (menu==1) {
				
				System.out.println("�ű�ȸ�� ���");
				
				manager.insert(new Silver(1002,"H",2000));
				manager.insert(new Silver(1003,"H",3000));
				manager.insert(new Gold(1004,"H",4000));
				manager.insert(new Ruby(1005,"H",5000));
				
		
			}else if (menu==2) {
				ArrayList<Member> members = manager.getMembers();
				System.out.println("ȸ�� ���� ���");
				System.out.println();
			
//				for(int i=0; i<members.size(); i++) {
				for( Member str : members ) {
					System.out.println(
							str.getId() + "\t "+
							str.getName()+ "\t "+
							str.getPoint()+ "\t "+
							str.getBonus());
							
							
							
//							members.get(i).getId() + "\t "+
//							members.get(i).getName() + "\t "+
//							members.get(i).getPoint()  + "\t "+
//							members.get(i).getBonus());
				}					
				//members = ArrayList, members.get(i)= Object,(members.get(i))).getId()= int 
				
				
				
			}else if(menu ==0) {
				System.out.println("������.");
			}else {System.out.println("�߸� �Է���");}
		}
	}
}

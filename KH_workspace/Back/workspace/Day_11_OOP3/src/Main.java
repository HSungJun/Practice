import java.util.Scanner;

import Classes.Gold;
import Classes.Member;
import Classes.Ruby;
import Classes.Silver;
import Manager.Manager;

public class Main {
	public static void main(String[] args) {

		//���
		//������
		//�߻�ȭ
		//Collection

		//ȸ������ �ý���
		//��� Ŭ���� ����(silver) : 
		//ȸ�� ID - int
		//ȸ�� �̸�
		//ȸ�� ����Ʈ
		
		//�ϼ��� �ڵ��� ������
		// �ڵ� �ߺ����� ���� (�������� ������) - > ������� �ذ� ���� [ IS - A ���� ]
		// �ڵ� ���յ��� ����(�������� ���� (�ٸ��ڵ忡�� ����)) - >  ������
		// ����� ���� - > Collection
		
		//Member �� Gold ���� ���� Ŭ������ �ν� (�θ��ڽİ��谰������)
		//���� Ŭ������ ���� Ŭ�����鰣�� ������"��"�� �Է��س��´�.
		//(Member���� ����(�θ�)Ŭ����)superClass / (Gold, Silver�� ���� ����(�ڽ�) Ŭ����)Derived Class
		//�����ڴ� �ڽ�Ŭ������ ����
		
		
		//Collection 
		//class Member > �迭 - ����� 
		//������ Ÿ�̹� > ��Ÿ�� 
		//����� �迭������ �ذ��ϱ� ���� ù��° ���  
		// 1. ���� �迭 >> Vector  >> ArrayLitst (�ҷ�, �Է��� ����, ������ �߾��°�� ���)
		// 2. LinkedList (�뷮, ������ ������ ��� ���)
		
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		
//		Member m = new Member();
		//abstract Ŭ������ �ν��Ͻ��� �������ʰڴ� ��� �ǹ̰� ����. ��� ���� �߻�
		
		
		System.out.println("=== ȸ������ �ý��� ===");
		System.out.println("1. �ű�ȸ�� ���"); 
		System.out.println("2. ȸ�� ���� ���");
		System.out.println("0. ����");
		System.out.println(">>");

		while(true) {
			int menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {

				manager.insert(new Silver(1001, "Tom", 1000));
				manager.insert(new Silver(1002, "Jane", 2000));
				manager.insert(new Silver(1003, "Mike", 3000));
				manager.insert(new Gold (1004, "Susan", 4000));
				manager.insert(new Ruby (1005, "Jack", 5000));
				
				
			}else if (menu==2) {
				
				Member[] members = manager.getMembers();
				
				System.out.println("ID\tName\tPoint\tBonus");

				for(int i = 0; i<manager.getIndex(); i++) {
					System.out.println(members[i].getId() + "\t" +
							members[i].getName() + "\t" + 
							members[i].getPoint() + "\t" +
							members[i].getBonus() + "\t");
				}
				


			}else if (menu==0) {
				System.out.println("�ý����� �����մϴ�.");
			}else {
				System.out.println("�޴��� �ٽ� Ȯ���� �ּ���.");
			}

		}
	}
}
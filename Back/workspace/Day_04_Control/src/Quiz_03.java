import java.util.Scanner;





public class Quiz_03 {
	public static void main(String[] args) {
		//���Ǳ� �ùķ�����
		Scanner sc = new Scanner(System.in);

		int money = (3000);
		int coke = (0);
		int soda = (0);
		int tea = (0);

/* if ���� ���� �����ݿ� ���� ��� ���� �� �̽��� ���� ���� �� ������ �� ������ ������
 while(true) �� ���� ���� �ݺ�. ������ ������ �˸��� �Բ� ���ƿ�*/
 
		if ( money <= 0) {
			System.out.println("�������� �����մϴ�.");
		}else if (money > 0) {
			while(true) {
				System.out.println("==== ���Ǳ� �ùķ����� ====");
				System.out.println("������� �����ϼ���");
				System.out.println("1. �ݶ�(1000)  2. ���̴�(800)  3.�Ž���(1500)  4.����  [0.����ǰ Ȯ��]");

				int select = Integer.parseInt(sc.nextLine());

				if (select == 1) {if (money < 1000) {
					System.out.println("�������� �����մϴ�. ���������"+ money +"���Դϴ�.");
				}else if (money >= 1000) {
//�ܾװ� ��ǰ������ ���� �� ���� ��� �� ��ȣ ���� ����
					System.out.println("�ݶ� �����ϼ̽��ϴ�.");
					coke += 1;
					System.out.println("�ݶ� : " + coke + "��");
					System.out.println("������ 1000�� ����.");
					money -= 1000;
				}

				}else if (select ==2) {if (money < 800) {
					System.out.println("�������� �����մϴ�. ���������"+ money +"���Դϴ�.");
				}else if (money >= 800) {
					System.out.println("���̴ٸ� �����ϼ̽��ϴ�.");
					soda += 1;
					System.out.println("���̴� : " + soda + "��");
					System.out.println("������ 800�� ����.");
					money -= 800;
				}

				}else if (select ==3) {if (money < 1500) {
					System.out.println("�������� �����մϴ�. ���������"+ money +"���Դϴ�.");
				}else if (money >= 1500) {
					System.out.println("�Ž����� �����ϼ̽��ϴ�.");
					tea += 1;
					System.out.println("�Ž��� : " + tea + "��");
					System.out.println("������ 1500�� ����.");
					money -= 1500;
				}

				}else if (select ==4) {
					System.out.println("���Ǳ� �ùķ����͸� �����մϴ�");
					System.exit(0);
					
				}else if (select == 0) {
					System.out.println("===== ���� ����ǰ ��� =====");
					System.out.println("������ : " + money );
					System.out.println("�ݶ� : " + coke);
					System.out.println("���̴� : " + soda);
					System.out.println("�Ž��� : " + tea);
					System.out.println("=========================");

				}else {System.out.println("�߸� �����ϼ̽��ϴ�. ������� ����ּ���.");}



			}

		}
	}
}


import java.util.Scanner;

public class Quiz_03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		
		
		while(true) {

			System.out.println("=== ���� ���� �� ���� ===");
			System.out.print("���ڸ� �����ϼ���. 1.���� 2.���� 3.�� : ");

			try {
			double com = Math.random();
			int user = Integer.parseInt(sc.nextLine());
			
			System.out.println("===== ��� =====");	
			
			
			if (user == 1){
				System.out.println("������ �����ϼ̽��ϴ�.");
				switch ((int)(com*3)+1) {
				case 1:
					System.out.println("                    ");
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
					System.out.println("===================");
					System.out.println("�����ϴ�! �ٽ��غ�����.");
					System.out.println("                    ");
					break;
				case 2:
					System.out.println("                    ");
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
					System.out.println("===================");
					System.out.println("�����ϴ�! �ٽ��غ�����.");
					System.out.println("                    ");
					break;
				case 3:
					System.out.println("                    ");
					System.out.println("��ǻ�ʹ� ���� �½��ϴ�.");
					System.out.println("===================");
					System.out.println("�̰���ϴ�! ���ϵ帳�ϴ�.");
					System.out.println("                    ");
					break;
				}
			}else if (user == 2){
				System.out.println("������ �����ϼ̽��ϴ�.");
				switch ((int)(com*3)+1) {
				case 1:
					System.out.println("                    ");
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
					System.out.println("===================");
					System.out.println("�̰���ϴ�! ���ϵ帳�ϴ�.");
					System.out.println("                    ");
					break;
				case 2:
					System.out.println("                    ");
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
					System.out.println("===================");
					System.out.println("�����ϴ�! �ٽ��غ�����.");
					System.out.println("                    ");
					break;
				case 3:
					System.out.println("                    ");
					System.out.println("��ǻ�ʹ� ���� �½��ϴ�.");
					System.out.println("===================");
					System.out.println("�����ϴ�! �ٽ��غ�����.");
					System.out.println("                    ");
					break;
				}
			}else if (user == 3){
				System.out.println("���� �����ϼ̽��ϴ�.");
				switch ((int)(com*3)+1) {
				case 1:			
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
					System.out.println("===================");
					System.out.println("�����ϴ�! �ٽ��غ�����.");
					System.out.println("                    ");
					break;
				case 2:			
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
					System.out.println("===================");
					System.out.println("�̰���ϴ�! ���ϵ帳�ϴ�.");
					System.out.println("                    ");
					break;
				case 3:				
					System.out.println("��ǻ�ʹ� ���� �½��ϴ�.");
					System.out.println("===================");
					System.out.println("�����ϴ�! �ٽ��غ�����.");
					System.out.println("                    ");
					break;
				}
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �������� �ٽ� ����ּ���");
			}
			}catch(Exception e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

		}


	}
}

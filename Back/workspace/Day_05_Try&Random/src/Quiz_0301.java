import java.util.Scanner;

public class Quiz_0301 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

int com = 0;																// ������ ���� �����Ͽ� �������� �������� �߻��ϴ°��� ����
int sel = 0;																// ������ ���� �����Ͽ� �������� �������� �߻��ϴ°��� ����

		while(true) {
			while (true) {
	here :		try {														// here �� ���� ��ġ ����
				com = (int)Math.random() *3+1; 								//��ǻ�� ���ð�
				System.out.println("=====���� ���� �� ����=====");
				System.out.print("���ڸ� �����ϼ��� (1.���� 2.���� 3.��)");
				sel = Integer.parseInt(sc.nextLine());						//����� ���ð� (���ڿ��� ���ڷ� �ٲ��ִ� ���)
																			//sc.nextLine > sc �� ������ ���� �Է�


				System.out.println("==========���==========");

				switch (sel) {
				case 1: 
					System.out.println("������ �����ϼ̽��ϴ�.");
					break;
				case 2:
					System.out.println("������ �����ϼ̽��ϴ�.");
					break;
				case 3:
					System.out.println("���� �����ϼ̽��ϴ�.");
					break;
				default: System.out.println("�����߿��� ���ÿ�");				//default �� ���� �� ���ý� break here�� ���� ��ܺ� here ��ġ�� �̵�
				break here;
				}
			
			
				switch (com) {
				case 1: 
					System.out.println("��ǻ�ʹ� ������ �����߽��ϴ�."); 
					break;
				case 2:
					System.out.println("��ǻ�ʹ� ������ �����߽��ϴ�."); 
					break;
				case 3:
					System.out.println("��ǻ�ʹ� ���� �����߽��ϴ�.");
					break;
				}

				if(sel == com) {
					System.out.println("���");
				}else if ((sel == 1 && com ==3)||(sel == 2 && com ==1)||(sel==3&&com==2)) {
					System.out.println("�̱�");
				}else if ((sel ==2&& com==3)||(sel==3&&com==1)||(sel==1&&com==2)) {
					System.out.println("��");
				}


			}catch (Exception e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

			}
		}
	}
}
}
import java.util.Scanner;

public class Quiz_01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ ���ɸ޴� - �ּҸ� �˷������. ");
		System.out.println("1.��ġ�� 2.�߱��� 3.�޲ٹ�");
		int menu = Integer.parseInt(sc.nextLine());
		
		if (menu==1 || menu ==2 || menu==3) {
			if (menu==1) {
				System.out.println("���ε���-���� ���α� ����� 78");
			}else if (menu ==2) {
				System.out.println("����-���� �߱� �ٵ��� 46 ");
			}else if (menu ==3) {
				System.out.println("�������� �޲ٹ�-���� ���α� ���ϴ��17�� 47-1");
			}else {System.out.println("�޴��� �ٽ� ����ּ���.");
				
			}
		}	
	}
}

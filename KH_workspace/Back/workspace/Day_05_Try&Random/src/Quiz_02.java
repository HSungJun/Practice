import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {

			System.out.println("=== ���� ��, �� ���߱�===");
			System.out.print("���ڸ� �Է����ּ��� (1.�ո�  2.�޸�) : ");
			
			try {
			double coin = Math.random();
			int sel = Integer.parseInt(sc.nextLine());
		// if �� ����Ͽ� sel ���� ������ ������ ���� ���� �ȿ� ������ �ÿ� ���� �Ǵ� ������� ����� ���� �� �ֵ��� ����� �Է�
			if (sel > 2 || sel < 0) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}else {
				if (sel == ((int)(coin*2)+1)) {
					System.out.println("������ϴ�^^");
				}else {
					System.out.println("��! Ʋ�Ƚ��ϴ�!");
				}
			}
			}catch(Exception e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");	
			}
		}
	}
}

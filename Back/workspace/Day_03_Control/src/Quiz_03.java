import java.util.Scanner;

public class Quiz_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1~100 ���� ������ ���ڸ� �Է����ּ��� : "); //��û����
		int num = Integer.parseInt(sc.nextLine()); // �Է�
		
		System.out.println("===== �� �� ====="); //�Է� �� ��� ���
		if (num < 1 || num >100) {
			System.out.println("�Է°� ������ �ʰ��ϼ̽��ϴ�. ó������ �ٽ� ������ �ּ���.");
		}else if (num%2==0) {
			System.out.println("�Է��Ͻ� ���� ��� ¦�� �Դϴ�. ");
		}else if (num%2==1){
			System.out.println("�Է��Ͻ� ���� ��� Ȧ�� �Դϴ�. ");
		}
		
	}
}

import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� �ϳ��� �Է��ϼ��� : ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("�ι�° ���� �ϳ� �� �Է��ϼ��� : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("===== �� �� =====");
	
		if (num1 > num2) {
			System.out.println("ù��° �Է��� ���� �� Ů�ϴ�.");
		}else if (num1 < num2) {
			System.out.println("�ι�° �Է��� ���� �� Ů�ϴ�.");
		}else if (num1 == num2) {
			System.out.println("�Է��� �� ���� �����մϴ�.");
		}//else {�μ��� ������츸 ���� -System.out.println("�Է��� �� ���� �����մϴ�.");
		//�ΰ��� ��� ����
}
	}


import java.util.Scanner;

public class Quiz_05 {
	public static void main(String[] args) {
		
		//�� ���ڸ� �Է¹޾� ������ ����� ����ϴ� ���α׷��� �ۼ�
		Scanner sc = new Scanner(System.in); //��ĳ��
		System.out.print("1�� ���� �Է¶� : "); //1�� �ȳ��� ���
		String str1 = sc.nextLine();		 //1�� �Է°� ����
		
		System.out.print("2�� ���� �Է¶� : "); //2�� �ȳ��� ���
		String str2 = sc.nextLine();		 //2�� �Է°� ����
		
		int num1 = Integer.parseInt(str1);	//1�� �Է°� ���ڷ� ��ȯ
		int num2 = Integer.parseInt(str2);	//2�� �Է°� ���ڷ� ��ȯ
		
		System.out.println("�Է��Ͻ� ������ ������ " + ( num1+num2 ) + " �Դϴ�.");
		// �Է°��� �� �� �ȳ�
		
		
		
	}
}

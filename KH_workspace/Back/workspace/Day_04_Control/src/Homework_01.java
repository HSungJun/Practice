import java.util.Scanner;

public class Homework_01 {
	public static void main(String[] args) {
		//1~n������ �� ���ϱ�
		//�հ踦 ������Ű�� ���Ѵ�.


		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== 1~n ������ �� ���ϱ� ===" );
		System.out.print("1�̻��� ���ڸ� �����ּ��� : ");
		int n = Integer.parseInt(sc.nextLine());
		
		int i=1;
		int sum = 0;
		
		while (i <= n) {	
			sum += i;
				i++;
		}
		System.out.println("1���� n ���� ���� : " + sum + "�Դϴ�.");
	}
}

import java.util.Scanner;

public class Test_01 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("���ڿ��� �Է����ּ��� : ");
			String str = sc.nextLine();
			// ���ڿ� �񱳿� == �� ����� �ÿ� str�� ���� "exit"�� �ּҸ� �����ϰԵȴ�.
			// == �� ��� Instance ���� �ּҸ� ���ϱ� ������ �Է°��� str��
			//������ exit �ΰ��� Ȯ���ϱ� ���ؼ��� str.equals("exit") �� ����ϸ�
			//==�� ����� ��� �񱳽ÿ� 
			//�ǵ��ʹ� �ٸ� ���� ��� �� �� �ֱ� ������ ���ڿ��� �񱳿��� ������ ���ڿ���
			//Ȯ���ϴ� ��쿡�� equals �� ����Ѵ�.
			if(str.equals("exit")) {
				break;
			}else {
				System.out.println(str.length()+" �����Դϴ�.");
			}
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
} 
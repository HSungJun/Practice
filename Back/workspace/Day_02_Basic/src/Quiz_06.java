import java.util.Scanner;

public class Quiz_06 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //�Էµ��� > ȣ�� ctrl shift o
		System.out.println("=======================");
		System.out.print("�� �� : ");
		String name = sc.nextLine();
		System.out.println("=======================");
		
		System.out.print("�� �� : ");
		String K = sc.nextLine();
		//double K = Double.parsaDouble(sc.nextLine()) ���� ����
		System.out.print("�� �� : ");
		String E = sc.nextLine();
		//double E = Double.parsaDouble(sc.nextLine())
		System.out.print("�� �� : ");
		//double E = Double.parsaDouble(sc.nextLine())
		String M = sc.nextLine();
				//sc.nextint()
		
	
		
		int num1 = Integer.parseInt(K);
		int num2 = Integer.parseInt(E);
		int num3 = Integer.parseInt(M);
		int sum = (num1+num2+num3); 
		int avg = (num1+num2+num3)/3; // 3.0���� ������ �Ǽ��� ��Ÿ��
		
		System.out.println("=======================");
		System.out.println("�� �� : " + sum);
		System.out.println("�� �� : " + avg);
		
	}
}

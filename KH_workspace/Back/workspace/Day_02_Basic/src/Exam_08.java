import java.util.Scanner;

public class Exam_08 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	//��ĳ�� �غ�		
		System.out.println("���� �Է� : ");
		String str = sc.nextLine();
	//�Է»��� ���� > �Է� > str �� ����
		int num = Integer.parseInt(str); //(�ȿ�)�ִ� ���� int(����)�� �м��ϴ� ���
	//("15")�� "" ���� > (15)�� ���� �� num�� 15�� ����
		System.out.println(num + 20 );//+20 �ҽ� �����ΰ� ����
		
	}
}

import java.lang.*;

public class Quiz_02 {
	public static void main(String[] args) {
		
	//������ �̸��� ����ϱ� ���� �ܼ��ϰ� ���� / a,b ���� ��� ���� ����ϱ� �����
	//num1 ���� Ư�� �̸�

		
		//3-1 1325�� 9327�� �޸𸮿� ����, �μ��� ���Ѱ�� ���
		int a = 1325;
		int b = 9327;
		System.out.println("3-1�� �� : " + a*b); 
	//�ڹٿ����� ������ �켱������ ���а� �����ϰ� ����
	//�ڹٿ��� ���ڿ����� + ������ ������ �ǹ�
		
		//3-2 100��� 5000�� ���� �޸𸮿� ����, ���
	long c = (10000000000L+5000);
		System.out.println("3-2�� �� : " + c);
	
		
		//3-3 'A'�� 'B'�� �޸𸮿� �����ϰ� ȭ�鿡 ����ϼ���
	char d = 'A'; 
	// String ch = "A" �� ���������� ������ '' ����߱� ������ char �̿�
	// String ch = "A" �� ��� A�� �ּ� ����, 'A'�� ��� ����65�� �ν�>����
	char e = 'B'; 
		System.out.println("3-3�� �� : " +'A');
		System.out.println("3-3�� �� : " +'B');
	
	}
}
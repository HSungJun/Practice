import java.util.Scanner;

public class Quiz_05_1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //ctrl shift o
		System.out.print("ù��° ���� �Է� : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("�ι�° ���� �Է� : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("�Է��Ͻ� �� ���� ���� " + (num1 + num2) + " �Դϴ�.");
	}
	
	
	
}

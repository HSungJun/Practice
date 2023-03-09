import java.util.Scanner;

public class Quiz_05_1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //ctrl shift o
		System.out.print("첫번째 숫자 입력 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자 입력 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("입력하신 두 수의 합은 " + (num1 + num2) + " 입니다.");
	}
	
	
	
}

import java.util.Scanner;

public class Quiz_06 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //입력도구 > 호출 ctrl shift o
		System.out.println("=======================");
		System.out.print("이 름 : ");
		String name = sc.nextLine();
		System.out.println("=======================");
		
		System.out.print("국 어 : ");
		String K = sc.nextLine();
		//double K = Double.parsaDouble(sc.nextLine()) 진행 가능
		System.out.print("영 어 : ");
		String E = sc.nextLine();
		//double E = Double.parsaDouble(sc.nextLine())
		System.out.print("수 학 : ");
		//double E = Double.parsaDouble(sc.nextLine())
		String M = sc.nextLine();
				//sc.nextint()
		
	
		
		int num1 = Integer.parseInt(K);
		int num2 = Integer.parseInt(E);
		int num3 = Integer.parseInt(M);
		int sum = (num1+num2+num3); 
		int avg = (num1+num2+num3)/3; // 3.0으로 나누면 실수로 나타남
		
		System.out.println("=======================");
		System.out.println("합 계 : " + sum);
		System.out.println("평 균 : " + avg);
		
	}
}

import java.util.Scanner;

public class Exam_06 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		while(true) {
			System.out.println("=== 계산기 프로그램 ===");
			System.out.print("연산자 입력 (+, -, *, /, q) : " );
			String calc = sc.nextLine();


			if (calc.equals("+")) {
				System.out.println("첫번째 숫자 입력 : ");
				int n1 = Integer.parseInt(sc.nextLine()); 
				System.out.println("두번째 숫자 입력 :");
				int n2 = Integer.parseInt(sc.nextLine()); 
				
				System.out.println("==== 결 과 ====");
				System.out.println("              ");	
				System.out.println("n1 + n2 : " + (n1+n2));
			}else if (calc.equals("-")) {
				System.out.println("첫번째 숫자 입력 : ");
				int n1 = Integer.parseInt(sc.nextLine()); 
				System.out.println("두번째 숫자 입력 :");
				int n2 = Integer.parseInt(sc.nextLine());
				
				System.out.println("==== 결 과 ====");
				System.out.println("              ");	
				System.out.println("n1 - n2 : " + (n1-n2));
			}else if (calc.equals("*")) {
				System.out.println("첫번째 숫자 입력 : ");
				int n1 = Integer.parseInt(sc.nextLine()); 
				System.out.println("두번째 숫자 입력 :");
				int n2 = Integer.parseInt(sc.nextLine());
				
				System.out.println("==== 결 과 ====");
				System.out.println("              ");	
				System.out.println("n1 * n2 : " + (n1*n2));
			}else if (calc.equals("/")) {
				System.out.println("첫번째 숫자 입력 : ");
				int n1 = Integer.parseInt(sc.nextLine()); 
				System.out.println("두번째 숫자 입력 :");
				int n2 = Integer.parseInt(sc.nextLine());
				
				double num3 = (n1/n2);
				System.out.println("==== 결 과 ====");
				System.out.println("              ");	
				System.out.printf("n1 / n2 : %.2f " , (num3));
				System.out.println();
			}else if (calc.equals("q")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {System.out.println("잘못 입력하셨습니다. 정확한 연산자를 입력해주세요.");}
		}
	}
}


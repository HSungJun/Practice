import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 하나를 입력하세요 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("두번째 숫자 하나 더 입력하세요 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("===== 결 과 =====");
	
		if (num1 > num2) {
			System.out.println("첫번째 입력한 값이 더 큽니다.");
		}else if (num1 < num2) {
			System.out.println("두번째 입력한 값이 더 큽니다.");
		}else if (num1 == num2) {
			System.out.println("입력한 두 값이 동일합니다.");
		}//else {두수가 같은경우만 존재 -System.out.println("입력한 두 값이 동일합니다.");
		//두가지 모두 가능
}
	}


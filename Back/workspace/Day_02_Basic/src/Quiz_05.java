import java.util.Scanner;

public class Quiz_05 {
	public static void main(String[] args) {
		
		//두 숫자를 입력받아 덧셈한 결과를 출력하는 프로그램을 작성
		Scanner sc = new Scanner(System.in); //스캐너
		System.out.print("1번 숫자 입력란 : "); //1번 안내문 출력
		String str1 = sc.nextLine();		 //1번 입력값 저장
		
		System.out.print("2번 숫자 입력란 : "); //2번 안내문 출력
		String str2 = sc.nextLine();		 //2번 입력값 저장
		
		int num1 = Integer.parseInt(str1);	//1번 입력값 숫자로 변환
		int num2 = Integer.parseInt(str2);	//2번 입력값 숫자로 변환
		
		System.out.println("입력하신 숫자의 총합은 " + ( num1+num2 ) + " 입니다.");
		// 입력값의 총 합 안내
		
		
		
	}
}

import java.util.Scanner;

public class Exam_05 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("메세지를 입력하세요 : ");
		String msg = sc.nextLine();
		
		if(msg.equals("Apple")) {
//자바 문자열 비교는 .equals = 주소비교가 아닌 문자 자체의 비교 ==는 안됨\
//
			System.out.println("사과입니다. ");
		}else if (msg.equals("Strawberry")) {
			System.out.println("딸기 입니다.");
		}else {
			System.out.println("메세지를 확인할 수 없습니다.");
		}
	}
}

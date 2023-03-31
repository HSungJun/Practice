import java.util.Scanner;

public class Exam_08 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	//스캐너 준비		
		System.out.println("숫자 입력 : ");
		String str = sc.nextLine();
	//입력상태 유지 > 입력 > str 에 저장
		int num = Integer.parseInt(str); //(안에)있는 것을 int(숫자)로 분석하는 명령
	//("15")의 "" 제거 > (15)만 저장 후 num에 15만 저장
		System.out.println(num + 20 );//+20 할시 숫자인게 증명
		
	}
}

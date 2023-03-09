import java.util.Scanner;

public class Quiz_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1~100 사이 임의의 숫자를 입력해주세요 : "); //요청사항
		int num = Integer.parseInt(sc.nextLine()); // 입력
		
		System.out.println("===== 결 과 ====="); //입력 후 결과 출력
		if (num < 1 || num >100) {
			System.out.println("입력값 범위를 초과하셨습니다. 처음부터 다시 실행해 주세요.");
		}else if (num%2==0) {
			System.out.println("입력하신 값의 경우 짝수 입니다. ");
		}else if (num%2==1){
			System.out.println("입력하신 값의 경우 홀수 입니다. ");
		}
		
	}
}

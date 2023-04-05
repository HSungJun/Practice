import java.util.Scanner;

public class Quiz_08 {
	public static void main(String[] args) {

		//System.exit(0); 프로그램 종료문
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("=== 구구단 출력 프로그램 ===");
//while 문에 true 리터럴값을 입력하여 종료 후 무제한으로 반복 가능.
		while (true) {
			System.out.print("1 ~ 9단 중 선택하세요 : (0 -> 종료) ");
			int i = Integer.parseInt(sc.nextLine());

			if (i == 0) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0); // 프로그램 종료 코드
			}
			
			if (i>0 && i<10) {
				int n = 1;
				while (n<10){
					System.out.println(i +" * " + n + " = " +(i*n));
					n++;
				}
			}else{
				System.out.println("잘못 선택하셨습니다.");
			}
		}
	}
}


// Ctrl a Ctrl i 자동 들여쓰기

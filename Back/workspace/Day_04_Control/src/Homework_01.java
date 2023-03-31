import java.util.Scanner;

public class Homework_01 {
	public static void main(String[] args) {
		//1~n까지의 합 구하기
		//합계를 누적시키며 더한다.


		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== 1~n 까지의 합 구하기 ===" );
		System.out.print("1이상의 숫자를 적어주세요 : ");
		int n = Integer.parseInt(sc.nextLine());
		
		int i=1;
		int sum = 0;
		
		while (i <= n) {	
			sum += i;
				i++;
		}
		System.out.println("1부터 n 까지 합은 : " + sum + "입니다.");
	}
}

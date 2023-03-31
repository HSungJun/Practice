import java.util.Scanner;

public class sum {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자입력하면 1부터 더한값 알려드림");
		int i;
		int sum = 0 ;
		int n = Integer.parseInt(sc.nextLine());
		
		
		for(i=0; i<=n; i++) {
			sum += i ;
		} 
		System.out.println(n+ " 까지의 합은 "+ sum + "입니다");
		
	}
}

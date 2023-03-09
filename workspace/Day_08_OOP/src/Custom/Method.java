package Custom;
import java.util.Scanner;

public class Method {
	
	public static String score (String str) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("name : ");
		String name = sc.nextLine();
		
		System.out.println("국어 점수 : ");
		int korean = Integer.parseInt(sc.nextLine());
		
		System.out.println("영어 점수 : ");
		int english = Integer.parseInt(sc.nextLine());
		
		System.out.println("수학 점수 : ");
		int math = Integer.parseInt(sc.nextLine());
		
		int sum = (korean + english + math);
		
		double avg = (sum / 3.0);
		
			String result = (name+ " / " + korean+ " , " +english+ " , " +math
				+ " 합계 : " + sum + " , 평균 : " +avg);
				
				return result; 
	
	}
	
	
}

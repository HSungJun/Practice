package Custom;
import java.util.Scanner;

public class Method {
	
	public static String score (String str) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("name : ");
		String name = sc.nextLine();
		
		System.out.println("���� ���� : ");
		int korean = Integer.parseInt(sc.nextLine());
		
		System.out.println("���� ���� : ");
		int english = Integer.parseInt(sc.nextLine());
		
		System.out.println("���� ���� : ");
		int math = Integer.parseInt(sc.nextLine());
		
		int sum = (korean + english + math);
		
		double avg = (sum / 3.0);
		
			String result = (name+ " / " + korean+ " , " +english+ " , " +math
				+ " �հ� : " + sum + " , ��� : " +avg);
				
				return result; 
	
	}
	
	
}

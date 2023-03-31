import java.util.Scanner;

public class BR31 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("== 31 Game ==");
				System.out.println("             ");
				System.out.println("1. Game Start");
				System.out.println("2. Game Score");
				System.out.println("3. End Game");
				
				int menu = Integer.parseInt(sc.nextLine());
				
				
				
			}catch (Exception e) {
				System.out.println("잘못 입력하였습니다.");
			}
			
		}
		
	}
}

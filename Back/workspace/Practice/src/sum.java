import java.util.Scanner;

public class sum {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�����Է��ϸ� 1���� ���Ѱ� �˷��帲");
		int i;
		int sum = 0 ;
		int n = Integer.parseInt(sc.nextLine());
		
		
		for(i=0; i<=n; i++) {
			sum += i ;
		} 
		System.out.println(n+ " ������ ���� "+ sum + "�Դϴ�");
		
	}
}

import java.util.Scanner;

public class Quiz_07 {
public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ��� ����ұ��? : ");
		
		int i = Integer.parseInt(sc.nextLine());
	
	while(i>0) {
	
		System.out.println("Hello world While : " + i); 
		i--;
	}
}
}

/*
		System.out.println("������ ��� ����ұ��? : ");
		int count = Integer.parseInt(sc.nextLine());
		int i =0;
		while(i < count) {
			i++;
			System.out.println("hello Java");
		}
*/

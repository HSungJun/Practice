import java.util.Scanner;

public class Quiz_07 {
public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("문장을 몇번 출력할까요? : ");
		
		int i = Integer.parseInt(sc.nextLine());
	
	while(i>0) {
	
		System.out.println("Hello world While : " + i); 
		i--;
	}
}
}

/*
		System.out.println("문장을 몇번 출력할까요? : ");
		int count = Integer.parseInt(sc.nextLine());
		int i =0;
		while(i < count) {
			i++;
			System.out.println("hello Java");
		}
*/

import java.util.Scanner;

public class ETC {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("이 름 : ");
		String name = sc.nextLine(); 
		// nextLine 버퍼를 비워버리고 nextInt는 버퍼에서 숫자만 인식
		// nextInt 사용시 버퍼에 잔여 입력물이 남아있는것을 인식 후 추후 nextLine으로
		// 처리해 주어야 함
		System.out.println("국 어 : ");
		int kor = sc.nextInt(); 
		
	}
}

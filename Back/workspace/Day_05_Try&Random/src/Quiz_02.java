import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {

			System.out.println("=== 동전 앞, 뒤 맞추기===");
			System.out.print("숫자를 입력해주세요 (1.앞면  2.뒷면) : ");
			
			try {
			double coin = Math.random();
			int sel = Integer.parseInt(sc.nextLine());
		// if 를 사용하여 sel 값의 범위를 지정한 이후 범위 안에 만족할 시에 정답 또는 오답등의 출력을 요할 수 있도록 명령을 입력
			if (sel > 2 || sel < 0) {
				System.out.println("잘못 입력하셨습니다.");
			}else {
				if (sel == ((int)(coin*2)+1)) {
					System.out.println("맞췄습니다^^");
				}else {
					System.out.println("땡! 틀렸습니다!");
				}
			}
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");	
			}
		}
	}
}

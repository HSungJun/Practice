import java.util.Scanner;

public class Test_01 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("문자열을 입력해주세요 : ");
			String str = sc.nextLine();
			// 문자열 비교에 == 을 사용할 시에 str의 경우는 "exit"의 주소를 저장하게된다.
			// == 의 경우 Instance 값의 주소를 비교하기 떄문에 입력값과 str이
			//동일한 exit 인것을 확인하기 위해서는 str.equals("exit") 를 사용하며
			//==을 사용할 경우 비교시에 
			//의도와는 다른 값이 출력 될 수 있기 때문에 문자열의 비교에서 동일한 문자열을
			//확인하는 경우에는 equals 를 사용한다.
			if(str.equals("exit")) {
				break;
			}else {
				System.out.println(str.length()+" 글자입니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
} 
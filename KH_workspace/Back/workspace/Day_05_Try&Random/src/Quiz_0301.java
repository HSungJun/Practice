import java.util.Scanner;

public class Quiz_0301 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

int com = 0;																// 변수를 먼저 선언하여 지역변수 문제점이 발생하는것을 방지
int sel = 0;																// 변수를 먼저 선언하여 지역변수 문제점이 발생하는것을 방지

		while(true) {
			while (true) {
	here :		try {														// here 을 통한 위치 지정
				com = (int)Math.random() *3+1; 								//컴퓨터 선택값
				System.out.println("=====가위 바위 보 게임=====");
				System.out.print("숫자를 선택하세요 (1.가위 2.바위 3.보)");
				sel = Integer.parseInt(sc.nextLine());						//사용자 선택값 (문자열을 숫자로 바꿔주는 명령)
																			//sc.nextLine > sc 의 변수에 문자 입력


				System.out.println("==========결과==========");

				switch (sel) {
				case 1: 
					System.out.println("가위를 선택하셨습니다.");
					break;
				case 2:
					System.out.println("바위를 선택하셨습니다.");
					break;
				case 3:
					System.out.println("보를 선택하셨습니다.");
					break;
				default: System.out.println("보기중에서 고르시오");				//default 로 보기 외 선택시 break here을 통한 상단부 here 위치로 이동
				break here;
				}
			
			
				switch (com) {
				case 1: 
					System.out.println("컴퓨터는 가위를 선택했습니다."); 
					break;
				case 2:
					System.out.println("컵퓨터는 바위를 선택했습니다."); 
					break;
				case 3:
					System.out.println("컴퓨터는 보를 선택했습니다.");
					break;
				}

				if(sel == com) {
					System.out.println("비김");
				}else if ((sel == 1 && com ==3)||(sel == 2 && com ==1)||(sel==3&&com==2)) {
					System.out.println("이김");
				}else if ((sel ==2&& com==3)||(sel==3&&com==1)||(sel==1&&com==2)) {
					System.out.println("짐");
				}


			}catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");

			}
		}
	}
}
}
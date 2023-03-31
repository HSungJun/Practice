// while(true) 의 위치에 따라 재시작 위치가 달라지기 때문에 재입력을 받아야 한다면 입력값
// 명령 위치보다 앞에 둘 것
// 입력값의 범위조건을 잘 확인하기
// 종료가 필요한 위치를 찾아 조건에 삽입
//switch 위 if 가 굳이 필요 없음.

import java.util.Scanner;

public class Quiz_01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("*** ATM 시뮬레이터 ***");
			System.out.println("1. 잔액조회");
			System.out.println("2. 입금하기");
			System.out.println("3. 출금하기");
			System.out.println("4. 종료하기");
			System.out.println(" >> ");

			int select = Integer.parseInt(sc.nextLine());

		//	if (select <0 || select <5) {
				switch(select) {
				case 1:
					System.out.println("잔액조회를 선택하셨습니다. ");
					break;
				case 2:
					System.out.println("입급하기를 선택하셨습니다. ");
					break;
				case 3:
					System.out.println("출금하기를 선택하셨습니다. ");
					break;
				case 4:
					System.out.println("종료하기를 선택하셨습니다. ");
					System.exit(0);
					break;
				default:
					System.out.println("메뉴를 다시 확인해 주세요");

				}
			//}

		}
	}
}





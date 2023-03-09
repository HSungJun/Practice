import java.util.Scanner;





public class Quiz_03 {
	public static void main(String[] args) {
		//자판기 시뮬레이터
		Scanner sc = new Scanner(System.in);

		int money = (3000);
		int coke = (0);
		int soda = (0);
		int tea = (0);

/* if 문을 통한 소지금에 따른 명령 실행 및 미실행 여부 설정 및 소지금 이 여유가 있을시
 while(true) 를 통한 구매 반복. 소지금 부족시 알림과 함께 돌아옴*/
 
		if ( money <= 0) {
			System.out.println("소지금이 부족합니다.");
		}else if (money > 0) {
			while(true) {
				System.out.println("==== 자판기 시뮬레이터 ====");
				System.out.println("음료수를 선택하세요");
				System.out.println("1. 콜라(1000)  2. 사이다(800)  3.매실차(1500)  4.종료  [0.소지품 확인]");

				int select = Integer.parseInt(sc.nextLine());

				if (select == 1) {if (money < 1000) {
					System.out.println("소지금이 부족합니다. 현재소지금"+ money +"원입니다.");
				}else if (money >= 1000) {
//잔액과 제품가격이 같을 때 등을 고려 한 등호 설정 주의
					System.out.println("콜라를 구매하셨습니다.");
					coke += 1;
					System.out.println("콜라 : " + coke + "개");
					System.out.println("소지금 1000원 차감.");
					money -= 1000;
				}

				}else if (select ==2) {if (money < 800) {
					System.out.println("소지금이 부족합니다. 현재소지금"+ money +"원입니다.");
				}else if (money >= 800) {
					System.out.println("사이다를 구매하셨습니다.");
					soda += 1;
					System.out.println("사이다 : " + soda + "개");
					System.out.println("소지금 800원 차감.");
					money -= 800;
				}

				}else if (select ==3) {if (money < 1500) {
					System.out.println("소지금이 부족합니다. 현재소지금"+ money +"원입니다.");
				}else if (money >= 1500) {
					System.out.println("매실차를 구매하셨습니다.");
					tea += 1;
					System.out.println("매실차 : " + tea + "개");
					System.out.println("소지금 1500원 차감.");
					money -= 1500;
				}

				}else if (select ==4) {
					System.out.println("자판기 시뮬레이터를 종료합니다");
					System.exit(0);
					
				}else if (select == 0) {
					System.out.println("===== 현재 소지품 목록 =====");
					System.out.println("소지금 : " + money );
					System.out.println("콜라 : " + coke);
					System.out.println("사이다 : " + soda);
					System.out.println("매실차 : " + tea);
					System.out.println("=========================");

				}else {System.out.println("잘못 선택하셨습니다. 음료수를 골라주세요.");}



			}

		}
	}
}


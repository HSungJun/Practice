import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {
//ATM 시뮬레이터
		Scanner sc = new Scanner(System.in);

		int total = (0); 
		// 총액의 경우 반복작업 내에 있을시 금액이 초기화가 대기 때문에 while 외부에 위치

		while(true) {
			System.out.println("*** ATM 시뮬레이터 ***");
			System.out.println("1. 잔액조회");
			System.out.println("2. 입금하기");
			System.out.println("3. 출금하기");
			System.out.println("4. 종료하기");
			System.out.println(" >> ");

			int select = Integer.parseInt(sc.nextLine());

			if (select==1) {
				System.out.println("잔액조회를 선택하셨습니다. ");
				System.out.println("현재 잔액은 " + total + "입니다.");
			}else if (select ==2) {
				System.out.println("얼마를 입급하시겠습니까? ");
				int in = Integer.parseInt(sc.nextLine());
				System.out.println(in + "원이 입금되었습니다. ");
				total += in;
			}else if (select==3) {
				System.out.println("얼마를 출금하시겠습니까? ");
				int out = Integer.parseInt(sc.nextLine());
				if (out > total) {	//출금액이 잔액보다 많을시 잔액초과안내
					System.out.println("출금가능 잔액을 초과하였습니다.");
					System.out.println("현재 잔액은 " + total +"원입니다.");
				}else if (out <total || out == total) { //출금액이 잔액과 동일,적을때 출금
					System.out.println(out+" 원이 출금 되었습니다.");
					total -= out; // 잔액에서 출금액을 차감
				}
			}else if (select==4) {
				System.out.println("종료하기를 선택하셨습니다. ");
				System.exit(0);
			}else {System.out.println("메뉴를 다시 확인해 주세요");}
		}

	}
}

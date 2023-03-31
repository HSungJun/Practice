import java.util.Scanner;

public class Quiz_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int total = (0);
		int in = (0);	
		int horse = (0);


		while (true) {
			
			try {
				System.out.println("☆★☆★경마게임에 오신것을 환영합니다.☆★☆★");
				System.out.println("메뉴를 선택해 주세요. ");
				System.out.println("1. 게임 시작");
				System.out.println("2. 잔액 충전");
				System.out.println("3. 잔액 조회");
				System.out.println("4. 종료");
				System.out.print(">>>>>>>>   ");

				int select = Integer.parseInt(sc.nextLine());

				if (select==1) {
					System.out.println("게임을 시작하겠습니다. ");
					System.out.println("말을 선택해주세요. ");
					System.out.println("1.어린 말");
					System.out.println("2.달리기가 제일 빠른 말");
					System.out.println("3.운이 좋은 말");
					horse = Integer.parseInt(sc.nextLine());
					if (horse < 0 || horse > 4) {
						System.out.println("해당 말 중에서 다시 골라주세요.");
					}else {
						
						System.out.println("현재 잔액은 " + total + "입니다.");
						System.out.println("얼마를 배팅 하시겠습니까? ");
						int bat = Integer.parseInt(sc.nextLine());
					
						if (bat > total) {
							System.out.println("잔액이 부족합니다.");
							System.out.println("현재 잔액은 " + total +"원입니다.");
							System.out.println("잔액을 충전해 주세요.");

						}else if (bat <= total) {
							
							System.out.println(bat+" 원을 배팅하였습니다. 가즈아ㅏㅏㅏㅏㅏㅏㅏ");
							total -= bat; 
							double win = Math.random()*3+1;

							System.out.println("======결과======");
							System.out.println("               ");
							if(horse == (int)win) {
								System.out.println("배팅에 성공하셨습니다!");
								total = (total + (bat*2));
								System.out.println("현재 잔액은" +total + " 원 입니다.");
							}else { 
								System.out.println("배팅에 실패하셨습니다.");
								System.out.println("배팅금액" + bat + " 원을 잃으셨습니다.");
							}
						}
					}
				}else if (select ==2) {
					System.out.println("잔액 충전을 선택하셨습니다.");
					System.out.println("얼마를 충전 하시겠습니까? ");
					in = Integer.parseInt(sc.nextLine());
					System.out.println(in + "원이 충전되었습니다. ");
					total += in;
				}else if (select ==3) {
					System.out.println("잔액조회를 선택하셨습니다. ");
					System.out.println("현재 잔액은 " + total +" 원 입니다.");

				}else if (select==4) {
					System.out.println("종료하기를 선택하셨습니다. ");
					System.exit(0);
				}else {System.out.println("메뉴를 다시 확인해 주세요");}

			}catch (Exception e) {
				System.out.println("메뉴에 맞는 숫자를 입력해주세요.");
			}
		}
	}
}	

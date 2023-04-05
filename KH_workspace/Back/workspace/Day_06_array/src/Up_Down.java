import java.util.Scanner;

public class Up_Down {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int score = 0;

		// 업앤다운 게임. 0-99까지 범위 랜덤한숫자 맞추기 게임
		// switch case 문으로 만들기

		while(true) {
			try {
				System.out.println("== Up & Down Game ==");
				System.out.println("                    ");
				System.out.println("1. Game Start");
				System.out.println("2. Game Score");
				System.out.println("3. End Game");
				System.out.println("");
				System.out.print(">> ");

				int menu = Integer.parseInt(sc.nextLine());
				double ran = (int)(Math.random()*100); 


				switch(menu) {
				case 1: 
					System.out.println("<< Game Start >>");
					while(true) {
						System.out.print("Input Number :  ");


						int sel = Integer.parseInt(sc.nextLine());
						if (sel<ran) {
							System.out.println("<< U P >>");
						}else if (sel>ran) {
							System.out.println("<<D O W N>>");
						}else if (sel == ran) {
							score += 1;
							System.out.println("<< 정 답 >>");
							System.out.println("1점 추가");

							break; // 정답일 시 메뉴화면으로 돌아가게하는 break
						}
					}break;// switch에 대한 break

				case 2:
					System.out.println("Game Score");
					System.out.println("");
					System.out.println("현재 점수는 "+score+" 점 입니다!.");

					break;
				case 3:
					System.out.println("게임을 종료합니다.");
					System.exit(0);

				default : System.out.println("다시 선택해 주십시오.");

				}

			}catch (Exception e) {
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}
}
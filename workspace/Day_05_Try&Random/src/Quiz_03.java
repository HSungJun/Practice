import java.util.Scanner;

public class Quiz_03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		
		
		while(true) {

			System.out.println("=== 가위 바위 보 게임 ===");
			System.out.print("숫자를 선택하세요. 1.가위 2.바위 3.보 : ");

			try {
			double com = Math.random();
			int user = Integer.parseInt(sc.nextLine());
			
			System.out.println("===== 결과 =====");	
			
			
			if (user == 1){
				System.out.println("가위를 선택하셨습니다.");
				switch ((int)(com*3)+1) {
				case 1:
					System.out.println("                    ");
					System.out.println("컴퓨터는 가위를 냈습니다.");
					System.out.println("===================");
					System.out.println("비겼습니다! 다시해보세요.");
					System.out.println("                    ");
					break;
				case 2:
					System.out.println("                    ");
					System.out.println("컴퓨터는 바위를 냈습니다.");
					System.out.println("===================");
					System.out.println("졌습니다! 다시해보세요.");
					System.out.println("                    ");
					break;
				case 3:
					System.out.println("                    ");
					System.out.println("컴퓨터는 보를 냈습니다.");
					System.out.println("===================");
					System.out.println("이겼습니다! 축하드립니다.");
					System.out.println("                    ");
					break;
				}
			}else if (user == 2){
				System.out.println("바위를 선택하셨습니다.");
				switch ((int)(com*3)+1) {
				case 1:
					System.out.println("                    ");
					System.out.println("컴퓨터는 가위를 냈습니다.");
					System.out.println("===================");
					System.out.println("이겼습니다! 축하드립니다.");
					System.out.println("                    ");
					break;
				case 2:
					System.out.println("                    ");
					System.out.println("컴퓨터는 바위를 냈습니다.");
					System.out.println("===================");
					System.out.println("비겼습니다! 다시해보세요.");
					System.out.println("                    ");
					break;
				case 3:
					System.out.println("                    ");
					System.out.println("컴퓨터는 보를 냈습니다.");
					System.out.println("===================");
					System.out.println("졌습니다! 다시해보세요.");
					System.out.println("                    ");
					break;
				}
			}else if (user == 3){
				System.out.println("보를 선택하셨습니다.");
				switch ((int)(com*3)+1) {
				case 1:			
					System.out.println("컴퓨터는 가위를 냈습니다.");
					System.out.println("===================");
					System.out.println("졌습니다! 다시해보세요.");
					System.out.println("                    ");
					break;
				case 2:			
					System.out.println("컴퓨터는 바위를 냈습니다.");
					System.out.println("===================");
					System.out.println("이겼습니다! 축하드립니다.");
					System.out.println("                    ");
					break;
				case 3:				
					System.out.println("컴퓨터는 보를 냈습니다.");
					System.out.println("===================");
					System.out.println("비겼습니다! 다시해보세요.");
					System.out.println("                    ");
					break;
				}
			}else {
				System.out.println("잘못 입력하셨습니다. 선택지를 다시 골라주세요");
			}
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}

		}


	}
}

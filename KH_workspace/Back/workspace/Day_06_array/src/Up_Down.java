import java.util.Scanner;

public class Up_Down {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int score = 0;

		// ���شٿ� ����. 0-99���� ���� �����Ѽ��� ���߱� ����
		// switch case ������ �����

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
							System.out.println("<< �� �� >>");
							System.out.println("1�� �߰�");

							break; // ������ �� �޴�ȭ������ ���ư����ϴ� break
						}
					}break;// switch�� ���� break

				case 2:
					System.out.println("Game Score");
					System.out.println("");
					System.out.println("���� ������ "+score+" �� �Դϴ�!.");

					break;
				case 3:
					System.out.println("������ �����մϴ�.");
					System.exit(0);

				default : System.out.println("�ٽ� ������ �ֽʽÿ�.");

				}

			}catch (Exception e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
			}
		}
	}
}
import java.util.Scanner;

public class Quiz_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int total = (0);
		int in = (0);	
		int horse = (0);


		while (true) {
			
			try {
				System.out.println("�١ڡ١ڰ渶���ӿ� ���Ű��� ȯ���մϴ�.�١ڡ١�");
				System.out.println("�޴��� ������ �ּ���. ");
				System.out.println("1. ���� ����");
				System.out.println("2. �ܾ� ����");
				System.out.println("3. �ܾ� ��ȸ");
				System.out.println("4. ����");
				System.out.print(">>>>>>>>   ");

				int select = Integer.parseInt(sc.nextLine());

				if (select==1) {
					System.out.println("������ �����ϰڽ��ϴ�. ");
					System.out.println("���� �������ּ���. ");
					System.out.println("1.� ��");
					System.out.println("2.�޸��Ⱑ ���� ���� ��");
					System.out.println("3.���� ���� ��");
					horse = Integer.parseInt(sc.nextLine());
					if (horse < 0 || horse > 4) {
						System.out.println("�ش� �� �߿��� �ٽ� ����ּ���.");
					}else {
						
						System.out.println("���� �ܾ��� " + total + "�Դϴ�.");
						System.out.println("�󸶸� ���� �Ͻðڽ��ϱ�? ");
						int bat = Integer.parseInt(sc.nextLine());
					
						if (bat > total) {
							System.out.println("�ܾ��� �����մϴ�.");
							System.out.println("���� �ܾ��� " + total +"���Դϴ�.");
							System.out.println("�ܾ��� ������ �ּ���.");

						}else if (bat <= total) {
							
							System.out.println(bat+" ���� �����Ͽ����ϴ�. ����Ƥ�������������");
							total -= bat; 
							double win = Math.random()*3+1;

							System.out.println("======���======");
							System.out.println("               ");
							if(horse == (int)win) {
								System.out.println("���ÿ� �����ϼ̽��ϴ�!");
								total = (total + (bat*2));
								System.out.println("���� �ܾ���" +total + " �� �Դϴ�.");
							}else { 
								System.out.println("���ÿ� �����ϼ̽��ϴ�.");
								System.out.println("���ñݾ�" + bat + " ���� �����̽��ϴ�.");
							}
						}
					}
				}else if (select ==2) {
					System.out.println("�ܾ� ������ �����ϼ̽��ϴ�.");
					System.out.println("�󸶸� ���� �Ͻðڽ��ϱ�? ");
					in = Integer.parseInt(sc.nextLine());
					System.out.println(in + "���� �����Ǿ����ϴ�. ");
					total += in;
				}else if (select ==3) {
					System.out.println("�ܾ���ȸ�� �����ϼ̽��ϴ�. ");
					System.out.println("���� �ܾ��� " + total +" �� �Դϴ�.");

				}else if (select==4) {
					System.out.println("�����ϱ⸦ �����ϼ̽��ϴ�. ");
					System.exit(0);
				}else {System.out.println("�޴��� �ٽ� Ȯ���� �ּ���");}

			}catch (Exception e) {
				System.out.println("�޴��� �´� ���ڸ� �Է����ּ���.");
			}
		}
	}
}	

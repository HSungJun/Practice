// while(true) �� ��ġ�� ���� ����� ��ġ�� �޶����� ������ ���Է��� �޾ƾ� �Ѵٸ� �Է°�
// ��� ��ġ���� �տ� �� ��
// �Է°��� ���������� �� Ȯ���ϱ�
// ���ᰡ �ʿ��� ��ġ�� ã�� ���ǿ� ����
//switch �� if �� ���� �ʿ� ����.

import java.util.Scanner;

public class Quiz_01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("*** ATM �ùķ����� ***");
			System.out.println("1. �ܾ���ȸ");
			System.out.println("2. �Ա��ϱ�");
			System.out.println("3. ����ϱ�");
			System.out.println("4. �����ϱ�");
			System.out.println(" >> ");

			int select = Integer.parseInt(sc.nextLine());

		//	if (select <0 || select <5) {
				switch(select) {
				case 1:
					System.out.println("�ܾ���ȸ�� �����ϼ̽��ϴ�. ");
					break;
				case 2:
					System.out.println("�Ա��ϱ⸦ �����ϼ̽��ϴ�. ");
					break;
				case 3:
					System.out.println("����ϱ⸦ �����ϼ̽��ϴ�. ");
					break;
				case 4:
					System.out.println("�����ϱ⸦ �����ϼ̽��ϴ�. ");
					System.exit(0);
					break;
				default:
					System.out.println("�޴��� �ٽ� Ȯ���� �ּ���");

				}
			//}

		}
	}
}





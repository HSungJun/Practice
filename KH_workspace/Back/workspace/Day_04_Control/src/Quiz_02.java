import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {
//ATM �ùķ�����
		Scanner sc = new Scanner(System.in);

		int total = (0); 
		// �Ѿ��� ��� �ݺ��۾� ���� ������ �ݾ��� �ʱ�ȭ�� ��� ������ while �ܺο� ��ġ

		while(true) {
			System.out.println("*** ATM �ùķ����� ***");
			System.out.println("1. �ܾ���ȸ");
			System.out.println("2. �Ա��ϱ�");
			System.out.println("3. ����ϱ�");
			System.out.println("4. �����ϱ�");
			System.out.println(" >> ");

			int select = Integer.parseInt(sc.nextLine());

			if (select==1) {
				System.out.println("�ܾ���ȸ�� �����ϼ̽��ϴ�. ");
				System.out.println("���� �ܾ��� " + total + "�Դϴ�.");
			}else if (select ==2) {
				System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�? ");
				int in = Integer.parseInt(sc.nextLine());
				System.out.println(in + "���� �ԱݵǾ����ϴ�. ");
				total += in;
			}else if (select==3) {
				System.out.println("�󸶸� ����Ͻðڽ��ϱ�? ");
				int out = Integer.parseInt(sc.nextLine());
				if (out > total) {	//��ݾ��� �ܾ׺��� ������ �ܾ��ʰ��ȳ�
					System.out.println("��ݰ��� �ܾ��� �ʰ��Ͽ����ϴ�.");
					System.out.println("���� �ܾ��� " + total +"���Դϴ�.");
				}else if (out <total || out == total) { //��ݾ��� �ܾװ� ����,������ ���
					System.out.println(out+" ���� ��� �Ǿ����ϴ�.");
					total -= out; // �ܾ׿��� ��ݾ��� ����
				}
			}else if (select==4) {
				System.out.println("�����ϱ⸦ �����ϼ̽��ϴ�. ");
				System.exit(0);
			}else {System.out.println("�޴��� �ٽ� Ȯ���� �ּ���");}
		}

	}
}

import java.util.Scanner;

public class ErrorTest {
	public static void main(String[] args) {

		//ATM �ùķ�����
		Scanner sc = new Scanner(System.in);

		int total = (0); 
		// �Ѿ��� ��� �ݺ��۾� ���� ������ �ݾ��� �ʱ�ȭ�� ��� ������ while �ܺο� ��ġ
		


		while(true) {
			int select;
			try {
				System.out.println("*** ATM �ùķ����� ***");
				System.out.println("1. �ܾ���ȸ");
				System.out.println("2. �Ա��ϱ�");
				System.out.println("3. ����ϱ�");
				System.out.println("4. �����ϱ�");
				System.out.println(" >> ");
				select = Integer.parseInt(sc.nextLine());
			
			}catch(Exception e) {
				System.out.println("�޴��� �˸��� ���ڸ� �Է����ּ���.");
			continue; // �� ��ġ�� �߿���. select �ν� �� ���ܹ߻��� ó��.
			}
				if (select==1) {
					System.out.println("�ܾ���ȸ�� �����ϼ̽��ϴ�. ");
					System.out.println("���� �ܾ��� " + total + "�Դϴ�.");
				}else if (select ==2) {
					System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�? ");

					while (true) {
						try {
							int in = Integer.parseInt(sc.nextLine());
							System.out.println(in + "���� �ԱݵǾ����ϴ�. ");
							total += in;
							break;
						}catch(Exception e) {
							System.out.println("��Ȯ�� ���ڸ� �Է��� �ּ���.");}
					}
				}
				else if (select==3) {
					System.out.println("�󸶸� ����Ͻðڽ��ϱ�? ");

					int out = Integer.parseInt(sc.nextLine());
					try {
						if (out > total) {	//��ݾ��� �ܾ׺��� ������ �ܾ��ʰ��ȳ�
							System.out.println("��ݰ��� �ܾ��� �ʰ��Ͽ����ϴ�.");
							System.out.println("���� �ܾ��� " + total +"���Դϴ�.");
						}else if (out <total || out == total) { //��ݾ��� �ܾװ� ����,������ ���
							System.out.println(out+" ���� ��� �Ǿ����ϴ�.");
							total -= out; // �ܾ׿��� ��ݾ��� ����
						}
					}catch (Exception e) {
						System.out.println("��Ȯ�� ���ڸ� �Է��� �ּ���.");
					}
				}else if (select==4) {
					System.out.println("�����ϱ⸦ �����ϼ̽��ϴ�. ");
					System.exit(0);
				}else {System.out.println("�޴��� �ٽ� Ȯ���� �ּ���");}
			}
			

		}
	}


import java.util.Scanner;

public class Exam_04 {
	public static void main(String[] args) {
		
		//swith - if���� ����� ���ѵ� ���
		//�ٸ� ����� �޸� (���ǹ� X(true,false x))) ����,������ ����
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�����ϴ� OTT��?");
		System.out.println("1.Netflix 2.Disney 3.Watcha");
		System.out.println(" >> ");
		
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
		//selcet �� ���� case1,2,3�� ���� ���� ��� ����
		// case �� select�� ���� ���ٸ�~ �̶�� ��� (ũ�ų� �۰ų��� ��� �Ұ���)
		// case ���� break �� ���� �ߺ����� ����
		case 1:
			System.out.println("Netflix�� �۷θ��� �α��Դϴ�.");
			break;
		case 2:
			System.out.println("Disney�� ī���밡 �α��Դϴ�.");
			break;
		case 3:
			System.out.println("Watcha�� �����.");
			break;
		default:
			System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
		
		}
		
		
	}
}

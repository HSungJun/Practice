import java.util.Scanner;

public class Exam_06 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		while(true) {
			System.out.println("=== ���� ���α׷� ===");
			System.out.print("������ �Է� (+, -, *, /, q) : " );
			String calc = sc.nextLine();


			if (calc.equals("+")) {
				System.out.println("ù��° ���� �Է� : ");
				int n1 = Integer.parseInt(sc.nextLine()); 
				System.out.println("�ι�° ���� �Է� :");
				int n2 = Integer.parseInt(sc.nextLine()); 
				
				System.out.println("==== �� �� ====");
				System.out.println("              ");	
				System.out.println("n1 + n2 : " + (n1+n2));
			}else if (calc.equals("-")) {
				System.out.println("ù��° ���� �Է� : ");
				int n1 = Integer.parseInt(sc.nextLine()); 
				System.out.println("�ι�° ���� �Է� :");
				int n2 = Integer.parseInt(sc.nextLine());
				
				System.out.println("==== �� �� ====");
				System.out.println("              ");	
				System.out.println("n1 - n2 : " + (n1-n2));
			}else if (calc.equals("*")) {
				System.out.println("ù��° ���� �Է� : ");
				int n1 = Integer.parseInt(sc.nextLine()); 
				System.out.println("�ι�° ���� �Է� :");
				int n2 = Integer.parseInt(sc.nextLine());
				
				System.out.println("==== �� �� ====");
				System.out.println("              ");	
				System.out.println("n1 * n2 : " + (n1*n2));
			}else if (calc.equals("/")) {
				System.out.println("ù��° ���� �Է� : ");
				int n1 = Integer.parseInt(sc.nextLine()); 
				System.out.println("�ι�° ���� �Է� :");
				int n2 = Integer.parseInt(sc.nextLine());
				
				double num3 = (n1/n2);
				System.out.println("==== �� �� ====");
				System.out.println("              ");	
				System.out.printf("n1 / n2 : %.2f " , (num3));
				System.out.println();
			}else if (calc.equals("q")) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}else {System.out.println("�߸� �Է��ϼ̽��ϴ�. ��Ȯ�� �����ڸ� �Է����ּ���.");}
		}
	}
}


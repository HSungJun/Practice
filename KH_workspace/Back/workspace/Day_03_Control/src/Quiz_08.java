import java.util.Scanner;

public class Quiz_08 {
	public static void main(String[] args) {

		//System.exit(0); ���α׷� ���Ṯ
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("=== ������ ��� ���α׷� ===");
//while ���� true ���ͷ����� �Է��Ͽ� ���� �� ���������� �ݺ� ����.
		while (true) {
			System.out.print("1 ~ 9�� �� �����ϼ��� : (0 -> ����) ");
			int i = Integer.parseInt(sc.nextLine());

			if (i == 0) {
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0); // ���α׷� ���� �ڵ�
			}
			
			if (i>0 && i<10) {
				int n = 1;
				while (n<10){
					System.out.println(i +" * " + n + " = " +(i*n));
					n++;
				}
			}else{
				System.out.println("�߸� �����ϼ̽��ϴ�.");
			}
		}
	}
}


// Ctrl a Ctrl i �ڵ� �鿩����

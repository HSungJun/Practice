import java.util.Scanner;

// �Է� Buffer? > �޸� ������ �ϳ�


//�ڵ忡 ���ڿ� �Է��� �ʿ��� ��� sc.nexLine(); �ʿ� > String�� �Է�


public class Exam_07 {
	public static void main(String[] args) {
		
		//������ �Է¹޴� ���
		Scanner sc = new Scanner(System.in); // Ctrl + shift + O(��)
		
		// System.in.read();�� �ܾ �޾ƿ��� ���
		// sc.nextLine(); �� String ���� �޾ƿ��� ���
		System.out.println("<�޼����� �����ּ���.>");
		String str = sc.nextLine(); //���� �������� ���� ���ڿ� �ϳ�
		//System.out.println(str);
		
		System.out.println("<����� ���� �޼�����>");
		System.out.println(str);
		
		
		
	}
}

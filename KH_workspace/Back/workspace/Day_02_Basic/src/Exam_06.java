//�⺻�Է�
// System/in.read() �Է� Buffer�κ��� Data�� ASCII�ڵ� ��ŭ �Է¹ޱ� ���� ��ɾ�
// ������� �Է��� Buffer��� ���� �ӽ� ���� �� ���ͷ� CPU���� �۾��� ��û


public class Exam_06 {
	public static void main(String[] args) throws Exception{
										// main���� ���ܻ�Ȳ�� �߻��� �ڵ�ó��
		
//System.in.read(); //���� : Unhandled exception type IOException
	
		//���� ��Ȳ�� ���۵������� ����		
	// - ���α׷� ����ڷκ��� �ѱ��� �Է��� �����ÿ�
	// *** ���ʱ��ڸ� �Է��ص� ���� �տ� �ѱ��ڸ� �ν�
	// *** int ������ �ν�
		//�ϴ� �ܼ�â ���� Terminate(������ư) // ctrl+F11 ����� ��ư Ȱ��ȭ
		//System.in.read ����� ������ư Ȱ��ȭ > 
	// ���� �������� ���� ���� �ϳ� > �Է°��� ������ ���� �� �ִ�.
	//UI - User Interface	
		System.out.print("�� ���ڸ� �Է����ּ���. : ");
		int input = System.in.read();
	
		
		//char ch = (char)input
		//System.out.println("�Է��Ͻ� ����"+ ch + "�� �ƽ�Ű�ڵ� 10������ "+ input + "�Դϴ�.");
		//�� �� �������ε� ����
		
		// System.out.println("�Է��Ͻ� ����"+ (char)input + "�� �ƽ�Ű�ڵ� 10������ "+ input + "�Դϴ�.");
		System.out.println("�Է��Ͻ� ���� : "+ input);
	
		System.out.println("�� ���ڸ� �Է����ּ���. : ");
		int input2 = System.in.read();
		System.out.println("�Է��Ͻ� ���� : "+ input2);
		// �ι� ����� 'A'��� �ܾ� �Է� �� ���� > ������ ���� \r\n ���� �ν�
		// ���ۿ� �ִ� A �ν� �� \r �� 13 �ν�, ���� \n �� 10 ���
		// ���۶�°� �ӽ� ������ �Է°��� ��� ����\
		// ���� �Է¶�Ȱ��ȭ�� ���� �� �տ��ִ� ������� ���
	
		
		
	}
}

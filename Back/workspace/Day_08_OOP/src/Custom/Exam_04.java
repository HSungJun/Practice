package Custom;

public class Exam_04 {
	public static void main(String[] args) {
		
		Temp t1 = new Temp();
		Temp t2 = new Temp();
		
		t1.a = 10;
		t2.a = 20;
		
		System.out.println(t1.a);
		System.out.println(t2.a);
		
		
		Temp.b = 30; // Temp Instance�� �������� �ʾƵ� �ٷ� ���� ���� 
//		t2.b = 40;
		
		System.out.println(t1.b);
		System.out.println(t2.b);
		// b �� ��� > Instance�� ���� ����������� Class �̸��� ���� ����ϴ°��� �����.
				
		//�������� > stack �޸�
		//�Ű����� > stack �޸�
		//������� > Heap �޸�
		//�������� > data �޸�
		
	}
}

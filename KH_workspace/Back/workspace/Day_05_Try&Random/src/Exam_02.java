/* ���� (Random Number)



*/
public class Exam_02 {
	public static void main(String[] args) {
		
		//0~1.0 ������ �Ǽ��� �������� ����
		double rand = Math.random();
	//	System.out.println(rand);
		
		//������ ���Ѱ��� �Ѱ谪�� �ȴ�
		System.out.println(rand * 10); // ���� 0~9 ������ ���� ����ϴ� �ڵ� 
		System.out.println((int)(rand * 6) + 1); // ���� 0~6 ������ ���� ����ϴ� �ڵ� (int�� �������, *6���� 5�� �Ѱ�ġ���������� +1�� 1~6 ���) 
		
		//37-52 ������ ����
		//���ϰ��� �ϴ� ���� �ּҰ� x �ִ밪 y 
		//(y-x+1)+x �� �������� �ִ� �ּҰ� ��� ����
		System.out.println((int)(rand * 16) + 37); // ���� 37~52 ������ ���� ����ϴ� �ڵ� (int�� �������, * 
		
		
		
		
		
		
	}
}


public class Quiz_01 {
	public static void main(String[] args) {
	
		byte b = 10;
		short s= 20;
		char c = 'A';
		int i;
		float f;
		long l = 100L;
		
		s=b;
		c=(char)b;
		s=(short)c;
		c=(char)s;// char�� ��� (�ƽ�Ű�ڵ�)�����ڵ� ��� > ���� 65 �Է½� A���
		i=(int)100L;
		l=500;
		f=l;
		f=(float)5.11;
		//f=5.11f; �� ��������
		
	//casting �� ����� ���� ���� > ������ �սǹ߻�
		System.out.println(c);
		
		
		
		
}
}

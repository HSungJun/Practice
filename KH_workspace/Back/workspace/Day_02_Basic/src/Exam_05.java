// ������ 
// ��Ģ1. ������ �������� ���Եȴ�. (���ܾ���) 
// ��Ģ2. ������ �ݵ�� �����̾�� �Ѵ�. (����) (������ �������� �ν�, ������ ������)



public class Exam_05 {
	public static void main(String[] args) {
		
	//	int a = 10;
	// ������(int) ����(a) ���Կ�����(=) ���ͷ���(10)
	// ���� ���� = ���� ��
		
		int A = 10; int B = 20;
		//A+=B;
//		System.out.println("A : " + A); // 30 ���
//		System.out.println("B : " + B); // 20 ���
	// ���Կ����� A+=B > A = A+B 
	//		 		  �� A �� 10 �� �ƴ� A��� �������� �ؼ�
		
	//%= ������ ������
	// A+=B;	A = A + B > A = 10+20
	// B-=A;	B = B - A > B = 20-10
	// A*=B;	A = A * B > A = 10*20
	// A/=B;	A = A / B > A = 10/20
	// A%=B;	A = A % B > a = 10%20

			//A + B; �����߻� > ���x �ǹ� ���� �������� ���� ���� 

	//���� ��(��ġ��)/��(��ġ��) ��ġ�� ���� �θ��� ��Ī�� �ٸ�
	//++A : ��ġ�� 
	//A-- : ��ġ��
		
	// A++; > A = A + 1; // A+=1; 
	// B--; > B = B - 1; // B-=1;
//		System.out.println("A : " + ++A); // ��ġ���� ��� �ٷ� 11��� - ���� ���		
//		System.out.println("A : " + A++); // ��ġ���� ��� 10 ��� ���� 11���
		
		//���迬���� - True or False ���� ���� (boolean��)
		//A == B > ��ȣ �ΰ��� ��� ���� ��� �ǹ� 
//		System.out.println(A == B); // A���� B ���� ����.
//		System.out.println(A != B); // A �� B ���� �ٸ���.
//		System.out.println(A < B); 
//		System.out.println(A > B); 
//		System.out.println(A <= B); // A�� B���� �۰ų� ����. ���� �ϳ��� ���̾ ��
//		System.out.println(A >= B); // A�� B���� ũ�ų� ����. 
		
	//System.out.println(10 < A < 20); �Ұ���
		
	// &&  (AND)������  (Ampersand > AND �ǹ�) ���ڸ� ������� ���� �ʴ´�
		// T && T = T  > �Ѵ� True �� ���� True
		// T && F = F  > �ϳ��� F ������ F
		// F && T = F
		// F && F = F 
		
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
	// || (or)������ (shift + \)
		// T || T = T 
		// T || F = T
		// F || T = T  > �ϳ��� T ������ T
		// F || F = F  > �Ѵ� False �϶��� False
		
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
	// 10 < A < 20 �ϱ� ���ؼ� && ������ ���.
	// �и� ��� : 10 < A && A < 20
		System.out.println(10 < A && A < 20);
		
	//�������� > shortcut (������ ����) 
		//A == B && A != B (���� �����ʴ� ��� �ǹ�)
		//false && true > ����� ��� �ΰ��� �� �ν�
		//��ǻ���� ��� �ռ� false �ν����� ���� false�� ���
		//A != B || A == B �� ���������� �ռ� �κ��� true�� ���
		
	}
}

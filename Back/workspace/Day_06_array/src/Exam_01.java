/* �迭 - ������ Ÿ���� ���� �������� ����
		�������� ������ �ѹ��� ���� ����
		���� ���� �������� ���������� �� �� �ִ�.
		
DataType [] �迭�̸�;

���� - �⺻��(������ ����) 8��(���� ������, ũ�� ����(stack memory)), 
	�׿� ������(�ּҰ� ����)


�޸� ���� 4����/ 
stack �۰� ������ ������
data
heap ������, ū������
text

*/
public class Exam_01 {
	public static void main(String[] args) {
		
//		���� heap �޸𸮸� ����Ѵ� >> new
		int[] arr = new int [] {10,20,30,40};
/*(heap �޸𸮿� ������� �ּҰ��� int[]�̶�� �� arr�� �����Ѵ�)
int []arr = ������ 16��Ʈ ����(new int[4];)�� �ּҸ� �����ϴ� ��������(int[] arr)
 �迭 ���� ���� : int�� ���� 4�� ���� 4byte 4��
16����Ʈ ¥�� ���� ����
 
int[] ��ü�� in, double, char ��� ���� �ڷ���
string[] �� ����		
		
(Scanner sc = new Scanner(System.in); �� new �� heap �޸𸮿� ����)

String str = new "Hello world" ���������μ� heap �޸𸮿� �����ϱ� ������ 
											new�� ����ؾ������� ���� ����
		
		
arr[0],arr[1],arr[2],arr[3]  >> []�� ÷�� �Ǵ� Index ��� ����
		������ 0 ���� > index = offset���� �������������� �󸶳� ������ �ִ°�
		
arr[0] > "arr�� ����� �ּҰ����� 0��ŭ ������ ����" ���� �ؼ�
		
arr�� �ڷ����� int[] �迭
		*/
		
//		arr[0] = 10; // > arr[0]�� �ڷ����� int 
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
		
		//int[] arr = new int [] {10,20,30,40};
		//�� �������� [] ���� ���� ����.
		
		
		
//		System.out.println(arr); // arr[1-1], arr[3/2] ���� �����ε� ǥ�� ����
//		System.out.println(arr[0]); // arr[(int)(Math.random())*3];
//		System.out.println(arr[1]); // arr[Integer.parseInt(sc.nextLine())];
//		System.out.println(arr[2]); // arr[a]
//		System.out.println(arr[3]); // �ñ������� ���ڸ� ǥ���� �����ϸ� ����
		
		
			int a = 0;
			
			for (a=0; a<=arr.length; a++) { // �̸�.length ����ǥ��. 
				System.out.println(arr[a]);
			}
		
			
		
		
		
		
		
	}
}

public class Exam_02 {
	public static void main(String[] args) {
		
		//int ������ 3ĭ���� arr1 �� �ۼ�
		//0 :48 1:99 2 :33 ���� �� ȭ�����
		
		int[] arr1 = new int[] {48,99,33};
			
		int a = 0;
		for(a=0; a<arr1.length; a++) {
			System.out.println(arr1[a]);
		}
		
		//String�� ���� 2ĭ¥�� arr2 0-Hello 1-World ���
		
		String[] arr2 = new String[] {"Hello", "World"};
		
		int s = 0;
		for(s=0; s<arr2.length; s++) {
			System.out.print(arr2[s]);
		}
		
		// char ������ 5ĭ¥�� arr3 A,r,r,a,y ���
		System.out.println(); // �ٹٲٱ� ��ɾ�
		
		char [] arr3 = new char[] {'A','r','r','a','y'};
		
		int c = 0;
		for(c=0; c<arr3.length; c++) {
			System.out.print(arr3[c]);
		}
		
	}
}

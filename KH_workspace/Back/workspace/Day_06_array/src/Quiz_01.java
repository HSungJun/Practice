
public class Quiz_01 {
	public static void main(String[] args) {
		
		// int �� ���� arr1 100�� 1~100 ���� ���� �� ���
		// int �� ���� arr2 100�� 100~1 ���� ���� �� ���
		// char �� ���� arr3 26�� A-Z���� ���� �� ���
		
		
		int a = 0;
		int[] arr1 = new int[100];
		
		for(a=0; a<arr1.length; a++) {
			arr1[a] = a+1; // arr1[a] += a; �� �� ��� ����� arr1[a]+1 �� �������
			System.out.println(arr1[a]);
		}
		
		// 100���� 1����
		int[] arr2 = new int[100];
		
		for(a=0; a<arr2.length; a++) {
			arr2[a] = 100-a;
			System.out.println(arr2[a]);
		}
			
		// char A-Z ��� A 
		char[] arr3 = new char[26];
		
		for(a=0; a<arr3.length; a++) {
			arr3[a] = (char)(65+a); 
		}
		System.out.println(arr3[a]);
		
		
	}
}

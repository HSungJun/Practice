
public class Quiz_01 {
	public static void main(String[] args) {
		
		// int 형 변수 arr1 100개 1~100 까지 저장 후 출력
		// int 형 변수 arr2 100개 100~1 까지 저장 후 출력
		// char 형 변수 arr3 26개 A-Z까지 저장 후 출력
		
		
		int a = 0;
		int[] arr1 = new int[100];
		
		for(a=0; a<arr1.length; a++) {
			arr1[a] = a+1; // arr1[a] += a; 로 할 경우 출력을 arr1[a]+1 로 변경출력
			System.out.println(arr1[a]);
		}
		
		// 100부터 1까지
		int[] arr2 = new int[100];
		
		for(a=0; a<arr2.length; a++) {
			arr2[a] = 100-a;
			System.out.println(arr2[a]);
		}
			
		// char A-Z 출력 A 
		char[] arr3 = new char[26];
		
		for(a=0; a<arr3.length; a++) {
			arr3[a] = (char)(65+a); 
		}
		System.out.println(arr3[a]);
		
		
	}
}

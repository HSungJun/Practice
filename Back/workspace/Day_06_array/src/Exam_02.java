
public class Exam_02 {
	public static void main(String[] args) {
		
		//int 형변수 3칸까지 arr1 로 작성
		//0 :48 1:99 2 :33 저장 후 화면출력
		
		int[] arr1 = new int[] {48,99,33};
			
		int a = 0;
		for(a=0; a<arr1.length; a++) {
			System.out.println(arr1[a]);
		}
		
		//String형 변수 2칸짜리 arr2 0-Hello 1-World 출력
		
		String[] arr2 = new String[] {"Hello", "World"};
		
		int s = 0;
		for(s=0; s<arr2.length; s++) {
			System.out.print(arr2[s]);
		}
		
		// char 형변수 5칸짜리 arr3 A,r,r,a,y 출력
		System.out.println(); // 줄바꾸기 명령어
		
		char [] arr3 = new char[] {'A','r','r','a','y'};
		
		int c = 0;
		for(c=0; c<arr3.length; c++) {
			System.out.print(arr3[c]);
		}
		
	}
}

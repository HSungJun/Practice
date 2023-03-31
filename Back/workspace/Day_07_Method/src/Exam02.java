
public class Exam02 {
	public static void main(String[] args) {
		
//		Math.random(); // random = 매개변수가 없고 return 값은 double
	
		String str = "Hello World";
		
		int length = str.length();
		
		char a = str.charAt(3); 
		int b = str.charAt(3); // (index)에 위치한 char
		// (str)변수가 가리키는 문자열의 (n(=0부터 시작))번째 문자를 (int or char)작성한 매개변수로 변환한다
		System.out.println(a);
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(3));
		System.out.println(b);
		

		System.out.println();
		String str1 = "l";
		// 일치하는 값이 있을땐 위치(n번째) 출력 > 없을땐 -1
		System.out.println(str.indexOf("A")); // -1 출력
		System.out.println(str.indexOf(str1)); // 가장앞의 l 의 위치인 2 출력
		
		System.out.println();
		str.startsWith(str1);
//		public boolean startsWith(String prefix) {
//	        return startsWith(prefix, 0);
//	    } prefix = 접두사 > 매개변수 boolean 이기떄문에 true false 로 도출
		
		// 문자열이 매개변수로 전달된 ("문자열")로 시작하는지 true or false 확인
		System.out.println(str.startsWith("H"));
		System.out.println(str.startsWith("e"));
		System.out.println(str.endsWith("d"));
		// startsWith 와 endsWith는 반대개념
		System.out.println();
		
		System.out.println(str.equals("d"));
		System.out.println(str.equals("Hello World"));
		// 같은 문자열인지 true false 출력
		
		System.out.println();
		System.out.println(str.contains(str1));
		System.out.println(str.contains("s"));
		// 문자열 내부에 (문자열 혹은 문자)가 포함되어있는지.
		
		System.out.println();
		String [] arr = str.split(" ");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		
		
		
		
	}
}

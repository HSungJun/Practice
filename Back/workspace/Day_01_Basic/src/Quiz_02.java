import java.lang.*;

public class Quiz_02 {
	public static void main(String[] args) {
		
	//변수의 이름을 기억하기 쉽고 단순하게 저장 / a,b 등의 경우 추후 기억하기 어려움
	//num1 등의 특정 이름

		
		//3-1 1325와 9327을 메모리에 저장, 두수를 곱한결과 출력
		int a = 1325;
		int b = 9327;
		System.out.println("3-1의 답 : " + a*b); 
	//자바에서도 연산자 우선순위는 수학과 동일하게 적용
	//자바에서 문자열끼리 + 연산은 연결을 의미
		
		//3-2 100억과 5000을 더해 메모리에 저장, 출력
	long c = (10000000000L+5000);
		System.out.println("3-2의 답 : " + c);
	
		
		//3-3 'A'와 'B'를 메모리에 저장하고 화면에 출력하세요
	char d = 'A'; 
	// String ch = "A" 도 가능하지만 문제는 '' 사용했기 때문에 char 이용
	// String ch = "A" 의 경우 A의 주소 저장, 'A'의 경우 숫자65로 인식>에러
	char e = 'B'; 
		System.out.println("3-3의 답 : " +'A');
		System.out.println("3-3의 답 : " +'B');
	
	}
}

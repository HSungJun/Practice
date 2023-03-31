
import java.util.Scanner;

/*Method - 인수를 전달받아 작업 후 결과를 반환하는 코드
class, mai

*/
public class Exam_01 { // 회사명
	//Method - 직원 추가
	//public static (변수정의) (정의부 이름)(변수정의)(변수명1,변수명2...)
	//변수정의 변수명a = 변수명1 (제어문) 변수명2;
	//	return 변수명a; 
	
	
	//return data type 되돌리려는 데이터의 자료형 > Method 의 시작명령
	//Method 정의부(Definition)
	public static /*일단 씀*/ int plus(int num1, int num2){
		int result = num1 + num2; 
		return result; 
		//Method가 콜된 부분으로 돌아간다.
		
	}
	//인자값 위치에 변수를 지정해 놓아야 받아 작동
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	//main은 프로그램의 시작점 / 직원 - 일처리함
		
		int result = plus(10,5);
		System.out.println(result);
		
		
		sc.nextLine();
		// String과 같다
//		 public String nextLine() {
//		        modCount++;
//		        if (hasNextPattern == linePattern())
//		            return getCachedResult();
//		        clearCaches();
//		인자값이 없으므로 매개변수(부분이 비어있음) 
		
		
		Math.random();
		// == double 과 같다
//		 public static double random() {
//		        return RandomNumberGeneratorHolder.randomNumberGenerator.nextDouble();
//		    }
		//double random()
		
		
		int kor = Integer.parseInt(sc.nextLine());
		//Stting 을 매개변수로서 값을 가지는 nextLine을 가진  parseInt를  
		// int 값으로 저장
		
		// public static int parseInt(String s) throws NumberFormatException {
		//     return parseInt(s,10);
		//    }
		//sc.nextLine
		//parseInt의 인자값 > sc.nextLine() > 의 인자값
		//int parseInt(String str)
		
		
		
		
		// plus(x,y) << Method call (매서드 호출부)
		//plus Method를 콜한다. ()은 (인자값 또는 인수값)(parameter, argument)으로 표현한다.
		//Method에 전달되어지는 값을 받는 변수를 매개변수 라고 한다
		//명령 후 ()일때에 if 등의 제어문이 아닌이상 전부 Method call
		/*
		System.out.println(result);		호출부
		sc.nextLine();					정의부는 JRE 시스템 내부에 존재
		Integer.parseInt(); 			
		Math.random();					
		
		위에서 만든 plus >>> 사용자정의 Method
		꺼내서 쓰는 타입 JRE System Library 에 저장되어있는 Method >>> Standard 내장 Method
		 */



		
		
		
	}
}
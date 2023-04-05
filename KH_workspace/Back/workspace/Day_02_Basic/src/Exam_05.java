// 연산자 
// 규칙1. 우항이 좌항으로 대입된다. (예외없음) 
// 규칙2. 좌항은 반드시 공간이어야 한다. (변수) (좌항은 공간으로 인식, 우항은 변수값)



public class Exam_05 {
	public static void main(String[] args) {
		
	//	int a = 10;
	// 자유형(int) 변수(a) 대입연산자(=) 리터럴값(10)
	// 좌항 공간 = 우항 값
		
		int A = 10; int B = 20;
		//A+=B;
//		System.out.println("A : " + A); // 30 출력
//		System.out.println("B : " + B); // 20 출력
	// 대입연산자 A+=B > A = A+B 
	//		 		  위 A 는 10 이 아닌 A라는 공간으로 해석
		
	//%= 나머지 연산자
	// A+=B;	A = A + B > A = 10+20
	// B-=A;	B = B - A > B = 20-10
	// A*=B;	A = A * B > A = 10*20
	// A/=B;	A = A / B > A = 10/20
	// A%=B;	A = A % B > a = 10%20

			//A + B; 오류발생 > 출력x 의미 없는 연산으로 인한 오류 

	//변수 앞(전치형)/뒤(후치형) 위치에 따라 부르는 명칭이 다름
	//++A : 전치형 
	//A-- : 후치형
		
	// A++; > A = A + 1; // A+=1; 
	// B--; > B = B - 1; // B-=1;
//		System.out.println("A : " + ++A); // 전치형의 경우 바로 11출력 - 먼저 계산		
//		System.out.println("A : " + A++); // 후치형의 경우 10 출력 이후 11출력
		
		//관계연산자 - True or False 값만 도출 (boolean형)
		//A == B > 등호 두개의 경우 같다 라는 의미 
//		System.out.println(A == B); // A값이 B 값과 같다.
//		System.out.println(A != B); // A 와 B 값이 다르다.
//		System.out.println(A < B); 
//		System.out.println(A > B); 
//		System.out.println(A <= B); // A가 B보다 작거나 같다. 둘중 하나만 참이어도 참
//		System.out.println(A >= B); // A가 B보다 크거나 같다. 
		
	//System.out.println(10 < A < 20); 불가능
		
	// &&  (AND)연산자  (Ampersand > AND 의미) 숫자를 대상으로 하지 않는다
		// T && T = T  > 둘다 True 일 때만 True
		// T && F = F  > 하나라도 F 있으면 F
		// F && T = F
		// F && F = F 
		
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
	// || (or)연산자 (shift + \)
		// T || T = T 
		// T || F = T
		// F || T = T  > 하나라도 T 있으면 T
		// F || F = F  > 둘다 False 일때만 False
		
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
	// 10 < A < 20 하기 위해서 && 연산자 사용.
	// 분리 사용 : 10 < A && A < 20
		System.out.println(10 < A && A < 20);
		
	//논리연산자 > shortcut (지름길 연산) 
		//A == B && A != B (같고 같지않다 라는 의미)
		//false && true > 사람의 경우 두가지 다 인식
		//컴퓨터의 경우 앞선 false 인식으로 인한 false로 출력
		//A != B || A == B 도 마찬가지로 앞선 부분이 true로 출력
		
	}
}

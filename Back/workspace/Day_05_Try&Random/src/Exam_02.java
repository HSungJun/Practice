/* 난수 (Random Number)



*/
public class Exam_02 {
	public static void main(String[] args) {
		
		//0~1.0 사이의 실수를 무작위로 생성
		double rand = Math.random();
	//	System.out.println(rand);
		
		//난수에 곱한값이 한계값이 된다
		System.out.println(rand * 10); // 난수 0~9 사이의 값을 출력하는 코드 
		System.out.println((int)(rand * 6) + 1); // 난수 0~6 사이의 값을 출력하는 코드 (int로 정수출력, *6으로 5의 한계치를가지지만 +1로 1~6 출력) 
		
		//37-52 사이의 난수
		//구하고자 하는 난수 최소값 x 최대값 y 
		//(y-x+1)+x 의 공식으로 최대 최소값 출력 가능
		System.out.println((int)(rand * 16) + 37); // 난수 37~52 사이의 값을 출력하는 코드 (int로 정수출력, * 
		
		
		
		
		
		
	}
}

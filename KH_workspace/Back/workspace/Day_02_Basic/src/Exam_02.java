//프로모션 및 캐스팅


public class Exam_02 {
	public static void main(String[] args) {
		
	//Data type Casting - 캐스팅 예시
		//작은 변수 안에 큰 변수를 대입(입력)시
		
		//byte a = b; > b 앞에 소괄호 및 변수 입력시 강제로 변환
		//일반적으로 자료의 손실이 발생
		short b = 1000;
		byte a = (byte)b;
		
		System.out.println(a);
		// 100대입시 출력가능 - byte 출력가능 > 1000 대입시 -24 도출 > 데이터 손실 발생
		
	}
}

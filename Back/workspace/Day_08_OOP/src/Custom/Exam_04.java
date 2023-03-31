package Custom;

public class Exam_04 {
	public static void main(String[] args) {
		
		Temp t1 = new Temp();
		Temp t2 = new Temp();
		
		t1.a = 10;
		t2.a = 20;
		
		System.out.println(t1.a);
		System.out.println(t2.a);
		
		
		Temp.b = 30; // Temp Instance를 생성하지 않아도 바로 선언 가능 
//		t2.b = 40;
		
		System.out.println(t1.b);
		System.out.println(t2.b);
		// b 에 경고 > Instance를 통해 사용하지말고 Class 이름을 통해 사용하는것이 권장됨.
				
		//지역변수 > stack 메모리
		//매개변수 > stack 메모리
		//멤버변수 > Heap 메모리
		//정적변수 > data 메모리
		
	}
}

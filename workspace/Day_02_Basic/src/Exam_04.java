
public class Exam_04 {
	public static void main(String[] args) {
		int i1 = 10;
		int i2 = 20;
		float f1 =3.14f;
		char c1 = 'A';
		char c2 = 'B';
		
		System.out.println("결과 : " + i1+i2 );
	//소괄호가 없을시 각각의 결과값에 "연결"
		System.out.println("결과 : " + (i1+i2));
	//소괄호 존재시 내부 연산의 경우 수학과 같이 계산
		System.out.println("결과 : " + i1+f1);
		System.out.println("결과 : " + (i1+f1));
		System.out.println("결과 : " + f1+c1);
		System.out.println("결과 : " + (f1+c1));
	//A+3.14 > 65+3.14 > 68.14
		System.out.println("결과 : " + c1+c2);
		System.out.println("결과 : " + (c1+c2));
	//A=65 > B=66 단계별 상승
	//""사용 문자열의 경우 연결
		
		
		
		
		
	}
}

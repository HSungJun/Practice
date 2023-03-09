
public class Exam_04 {
	public static void main(String[] args) {
		
		int a =10;
		int b =20;
		
		System.out.println(a+ " : "+b);
		// a 와 b 의 값이 바뀌어 나오도록 한다.
		int tmp ; // 값 교환을 위한 임시변수
		//temporary = 임시 /
		tmp=a;
		a=b;
		b=tmp;
		//swap 기법
		
		System.out.println(a+ " : "+b);
	}
}

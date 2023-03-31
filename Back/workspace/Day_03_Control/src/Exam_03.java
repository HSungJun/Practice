
public class Exam_03 {
	public static void main(String[] args) {
		
		// 매개변수, 멤버변수, 정적변수도 존재
		// int a = 10; 지역변수 Local variable
		// {범위} == 지역 / 지역안에서 변수가 생성> 지역을 벗어나면 변수 삭제
		
		{int a = 20; System.out.println(a);} 
		{int a = 10; System.out.println(a);} // 두 지역은 다른 지역으로 중복사용 가능
		//상위 지역에서 만든 변수는 안쪽지역에서 중복사용 불가능, 그러나 출력은 안쪽에서 가능
		
	// null == 숫자 0 을 문자로 표현한 단어
	
//		String str = null;
//		int menu = 1;
//		if (menu ==1) {
//			str = "hello"
//		}else if (menu==2) {
//			str = "World"
//		}
//		
//	
	}
}

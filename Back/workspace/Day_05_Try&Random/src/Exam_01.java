


public class Exam_01 {
	public static void main(String[] args) {
		
		try {
		
		// paseInt 는 문자열이지만 숫자"만" 인식
		// 문자 그 자체가 들어갈 경우 오류
		int num = Integer.parseInt("123");
		// java.lang.NumberFormatException 이라는 오류 발생 > 에러 발생하자마자 프로그램종료
		System.out.println("분석된 숫자는 : " + num );
		
		
//예외 전가 (Throws exception)
//예외 처리 - try { }catch (Exception e) {}	
//try내부 오류(예외) 발생시 catch 부분으로 이동하여 개발자가 취해주고자 하는 명령 실행		
//예외 미발생시 코드 순으로 진행하며 catch를 건너 뜀		
		}catch (Exception e) {
			System.out.println("분석하려는 데이터가 숫자의 형태가 아닙니다.");
		} 
		System.out.println("프로그램 정상 종료.");
	}
}

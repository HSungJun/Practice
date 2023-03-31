//기본입력
// System/in.read() 입력 Buffer로부터 Data를 ASCII코드 만큼 입력받기 위한 명령어
// 사용자의 입력이 Buffer라는 곳에 임시 저장 후 엔터로 CPU에게 작업을 요청


public class Exam_06 {
	public static void main(String[] args) throws Exception{
										// main에서 예외상황이 발생시 자동처리
		
//System.in.read(); //에러 : Unhandled exception type IOException
	
		//예외 상황이 조작되지않은 에러		
	// - 프로그램 사용자로부터 한글자 입력을 받으시오
	// *** 수십글자를 입력해도 제일 앞에 한글자만 인식
	// *** int 형으로 인식
		//하단 콘솔창 우측 Terminate(정지버튼) // ctrl+F11 실행시 버튼 활성화
		//System.in.read 실행시 정지버튼 활성화 > 
	// 아직 정해지지 않은 숫자 하나 > 입력값은 정수에 담을 수 있다.
	//UI - User Interface	
		System.out.print("한 글자를 입력해주세요. : ");
		int input = System.in.read();
	
		
		//char ch = (char)input
		//System.out.println("입력하신 문자"+ ch + "의 아스키코드 10진수는 "+ input + "입니다.");
		//위 두 문단으로도 가능
		
		// System.out.println("입력하신 문자"+ (char)input + "의 아스키코드 10진수는 "+ input + "입니다.");
		System.out.println("입력하신 문자 : "+ input);
	
		System.out.println("한 글자를 입력해주세요. : ");
		int input2 = System.in.read();
		System.out.println("입력하신 문자 : "+ input2);
		// 두번 실행시 'A'라는 단어 입력 후 엔터 > 엔터의 경우는 \r\n 으로 인식
		// 버퍼에 있는 A 인식 후 \r 인 13 인식, 이후 \n 인 10 출력
		// 버퍼라는건 임시 공간에 입력값을 모두 저장\
		// 이후 입력란활성화시 버퍼 내 앞에있는 순서대로 출력
	
		
		
	}
}

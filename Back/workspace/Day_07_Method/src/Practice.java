
public class Practice {

	//두 정수를 인자로 전달받아 뺄셈한 경과를 반환하는 Minus 메서드
	public static int minus(int num1, int num2) {
		int result = (num1 - num2);
		return result;
	}


	//두 정수를 인자로 전달받아 나눗셈한 결과를 실수로 반환하는 divide 메서드
	public static int divide(int num1, int num2) {
		int result = (num1/num2);
		return result;
	}



	//두 정수를 인자로 전달받아 더 큰수를 반환하는 bigger 매서드
	//두 수가 같다면 0을 반환
	public static int bigger (int num1, int num2) {
		int result = 0;
		if(num1<num2) {
			result = num2;
		}else if (num1 == num2) {
			result = 0;
		}else if (num1 > num2) {
			result = num1;
		}return result;
	}

	// "사과"를 인자로 전달하면 Apple, "딸기" 를 인자로 전달하면 Strawberry를 반환하는
	// Translate 메서드 제작 다른값은 none


	public static String translate(String a) {
		// 메소드 원형
		if(a.equals("딸기")) {
			a = "Strawberry";
		}else if (a.equals("사과")) {
			a = "Apple";
		}else { a= "none";}
		return a;
		
	}// ==을 사용하지 않는 이유는 문자열 이기 때문 > 주소가아닌 글자를 비교할거기 때문에 equals 사용 
	// == 로 출력시 true 가 나오는 이유는 문자열을 사용한 적이 있으면 이후에는 그 문자열의 주소를 저장. 
	// 고로 주소가 같기 때문에 true 출력
	//(공유 문자열 저장소 shared string pool)

	//입력받을때에 계산기(day4 exam6)의 경우 n번 입력받아 입력받아야하기때문에 복잡하고 귀찮음
	//Day_04 Teachers_code Method or Daay_07 Calculator에 Method 값 생성
	
	
	public static void main(String[] args) {
		System.out.println(minus(10,2));
		System.out.println(divide(10,2));
		System.out.println(bigger(10,5));
		System.out.println(translate("딸기"));
		System.out.println(translate("사과"));
		System.out.println(translate("포도"));
		

	}
}

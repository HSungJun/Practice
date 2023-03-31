import java.util.Scanner;

// byte		1byte	8bit	-128 ~ 127
// short	2byte	16bit	-32,768 ~ 32,767
// char		2byte	16bit	0 ~ 65535(유니코드)
// int		4byte	32bit	-2,147,483,648 ~ 2,147,483,647
// long		8bit	64bit	-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807

// float	4byte	32bit	1.4E-45 ~ 3.4028235E38 (10^-38 ~ 10^38)
// double	8byte	64bit	4.9E-324 ~ 1.7976931348623157E308 (10^-308~ 10^308)

// boolean	1byte	8bit	true / false
// String 
//위 두가지는 형변환이 불가능

// void 					값을 가지지 않는 특수데이터
		


		//System.out.println(3/2); // > 1.5 이지만 1로 출력 
		
// (흐름)제어문 > 조건 반복 선택 흐름변경
// 코드는 위>아래 흐름 > 제어문을 통한 흐름 통제,제어
		
	//조건문 (분기문)  if 과정과 결과에 따라 행위 결정. if문 결과가 참일 때 명령 수행 
	
	//if (조건문(boolean을 만들어내는 수식연산수행 true or false)) 
	//    {실행문;} 의 형태

public class Exam_01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신이 좋아하는 과일은 무엇입니까?");
		System.out.println("1. 사과  2. 망고 3. 딸기");
		System.out.println(">> ");
		int menu = Integer.parseInt(sc.nextLine());
		
//		if (menu == 1) {
//			System.out.println("사과는 영어로 Apple 입니다. ");
//		}
//		//menu 라는 값이 1 과 같다 >사용자의 입력(선택이 1번이라면) > true or false
//		//else if > 종속성 문법 > if없이 쓸 수 없는 명령 > 그렇지 않으면
//		else if (menu == 2) {
//			System.out.println("망고는 영어로 Mango 입니다. ");
//		//else if를 써야하는 경우 > 경우의 수가 많을 경우
//		//if를 두개로 나누어야 하는 경우도 존재함
//		}else if (menu ==3) {
//			System.out.println("딸기는 영어로 Strawberry 입니다. ");
//		}else {
//			System.out.println("메뉴를 다시 확인해 주세요. ");
		}//else는 위 조건이 전부 아닐경우 사용 소괄호 x 중괄호 만 사용
	
		//if문 안에 if문 등의 {내부에} 중첩 사용이 가능 
	
		//if문 이전 사용자의 입력값을 확인 후 다음 if문으로 진행하도록 가능
//		if(menu ==1||menu==2||menu==3) {메뉴 123 or else 삽입}
		

}

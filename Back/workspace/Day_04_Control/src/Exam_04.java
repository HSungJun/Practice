import java.util.Scanner;

public class Exam_04 {
	public static void main(String[] args) {
		
		//swith - if보다 기능이 제한된 제어문
		//다른 제어문과 달리 (조건문 X(true,false x))) 정수,문자형 변수
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("좋아하는 OTT는?");
		System.out.println("1.Netflix 2.Disney 3.Watcha");
		System.out.println(" >> ");
		
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
		//selcet 의 값이 case1,2,3의 각자 값이 경우 실행
		// case 는 select의 값이 같다면~ 이라는 명령 (크거나 작거나의 경우 불가능)
		// case 이후 break 를 통해 중복도출 방지
		case 1:
			System.out.println("Netflix는 글로리가 인기입니다.");
			break;
		case 2:
			System.out.println("Disney는 카지노가 인기입니다.");
			break;
		case 3:
			System.out.println("Watcha는 몰라요.");
			break;
		default:
			System.out.println("메뉴를 다시 확인해주세요.");
		
		}
		
		
	}
}

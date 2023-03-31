import java.util.Scanner;

import Classes.Gold;
import Classes.Member;
import Classes.Ruby;
import Classes.Silver;
import Manager.Manager;

public class Main {
	public static void main(String[] args) {

		//상속
		//다형성
		//추상화
		//Collection

		//회원관리 시스템
		//등급 클래스 설계(silver) : 
		//회원 ID - int
		//회원 이름
		//회원 포인트
		
		//완성된 코드의 문제점
		// 코드 중복도가 높음 (유지보수 문제점) - > 상속으로 해결 가능 [ IS - A 관계 ]
		// 코드 결합도가 높음(의존도가 높음 (다른코드에도 영향)) - >  다형성
		// 저장소 문제 - > Collection
		
		//Member 와 Gold 상위 하위 클래스로 인식 (부모자식관계같은느낌)
		//상위 클래스는 하위 클래스들간의 공통요소"만"을 입력해놓는다.
		//(Member등의 상위(부모)클래스)superClass / (Gold, Silver와 같은 하위(자식) 클래스)Derived Class
		//생성자는 자식클래스에 생성
		
		
		//Collection 
		//class Member > 배열 - 저장소 
		//컴파일 타이밍 > 런타임 
		//저장소 배열문제를 해결하기 위한 첫번째 대안  
		// 1. 동적 배열 >> Vector  >> ArrayLitst (소량, 입력은 자주, 삭제는 잘없는경우 사용)
		// 2. LinkedList (대량, 삭제를 자주할 경우 사용)
		
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		
//		Member m = new Member();
		//abstract 클래스는 인스턴스를 만들지않겠다 라는 의미가 있음. 고로 오류 발생
		
		
		System.out.println("=== 회원관리 시스템 ===");
		System.out.println("1. 신규회원 등록"); 
		System.out.println("2. 회원 정보 출력");
		System.out.println("0. 종료");
		System.out.println(">>");

		while(true) {
			int menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {

				manager.insert(new Silver(1001, "Tom", 1000));
				manager.insert(new Silver(1002, "Jane", 2000));
				manager.insert(new Silver(1003, "Mike", 3000));
				manager.insert(new Gold (1004, "Susan", 4000));
				manager.insert(new Ruby (1005, "Jack", 5000));
				
				
			}else if (menu==2) {
				
				Member[] members = manager.getMembers();
				
				System.out.println("ID\tName\tPoint\tBonus");

				for(int i = 0; i<manager.getIndex(); i++) {
					System.out.println(members[i].getId() + "\t" +
							members[i].getName() + "\t" + 
							members[i].getPoint() + "\t" +
							members[i].getBonus() + "\t");
				}
				


			}else if (menu==0) {
				System.out.println("시스템을 종료합니다.");
			}else {
				System.out.println("메뉴를 다시 확인해 주세요.");
			}

		}
	}
}
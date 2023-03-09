package exams;
import java.util.Scanner;

import Custom.TV;

public class Exam_01 {
	public static void main(String[] args) {
		
		TV lg = new TV();
		//TV 인스턴스를 heap메모리에 저장한 주소를 lg라는 변수에 들어감.
		//lg.~ 의 경우 필드를 수정 출력 할 수 있음.
		
		lg.setChannel(10);
		lg.setBrand("LG");
		lg.setPrice(1200000);
		lg.setWeight(7);
		
		System.out.println(lg.getWeight()+"kg");
		
//		heap 메모리에 TV생성 and 주소를 받은 후에 samsung에다 그 주소를 저장한 명령
//클래스를 만들면 참조자료형으로 제작할수있다.
//TV의 주소를 저장한 참조 변수를 만드는 것.
		
//		new TV(); > 변수에 담아두어야 한다.
		
//		new 를 통한 heap메모리에 생성
//		new 를 통해서 만들어진 TV 를 (객체)Instance 라고 함 / TV instance를 생성함
//		new 는 heap 메모리에 TV를 생성하고 그 주소를 new 위치에 return & 저장

		
//		samsung 이라는 곳에 찾아가겠다 > .
//		Ctrl+Space 로 확인 TV class 에 생성한 brand Price 등의 정보를 가지고있다
		
//		Scanner sc = new Scanner(System.in);
//		Scanner 클래스(설계도) heap 매모리 내 Scanner의 주소를 sc 라는 변수에 저장 
//		String str = sc.nextLine();

		
		
		
		
	}
}

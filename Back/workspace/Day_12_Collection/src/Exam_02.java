import java.util.ArrayList;
import java.util.Scanner;


class A extends Object {
	
}


public class Exam_02 {
	public static void main(String[] args) {
	
		
		A a= new A();
		//a.
		//Java의 상속의 최상단에 Object가 항상 붙어있다.
		
		
		
		
		ArrayList<String> arr = new ArrayList();
//		ArrayList arr = new ArrayList();
	//다형성
	//add 를 통한 ()내의 데이터들은 객체로 인식
	//자바 내 Object 최상단 자료형 / 모든 타입에 대한 다형성을 가짐
	
	
	Object o = new Scanner(System.in);
	o = new Integer(10); // Auto Boxing 자동변환
	
	
	arr.add("Hello");
	arr.add("World");
	arr.add("Collection");
	
	for(int i=0; i<arr.size(); i++) {
	System.out.println(arr.get(i));
	}
	
	
	//fir rich문 // 오른쪽에 collection 이 존재한다는 전제하에 사용
	//반복의 횟수나 정의를 할 수 없음. 무조건 배열(또는 collection)을 전부 반복
	// for ( : ) : 우측은 collection 으로 데이터가 많은것 입력
	// 자신이 가지고 있는 요소에서 반복할 때마다 왼쪽으로 보냄.
	// 좌측은 우측의 데이터를 받을 동일형태의 변수를 입력
	// 우측 요소가 존재할시에 계속 반복 
	for( String str : arr ) {
		System.out.println(str);
	}
		
		
		
//	arr.add(10);
	
//	System.out.println(((String)arr.get(2)).length());
	
//	System.out.println(arr.get(0));
//	System.out.println(arr.get(1));
//	System.out.println(arr.get(2));
	
//	arr.remove(0);
//	
//	arr.add(1,"Java");
//	
//	
//	System.out.println(arr.get(0));
//	System.out.println(arr.get(1));
//	System.out.println(arr.get(2));
//
//	System.out.println(arr.size());
	
	//배열의 경우 arr[i] = 10; 등으로 등호를 이용하였으나, ArrayList는 .add(i)를 이용한다.
	
	
	}
}

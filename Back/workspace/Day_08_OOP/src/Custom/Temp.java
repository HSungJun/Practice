package Custom;
/* Class -만들고자 하는 대상의 설계도
 * 		Member Field, Member Method, Constructor


*/
public class Temp {			//static의 유무에 따른 명칭의 차이
	public int a; 			//Instance Member Field > Temp Class를 이용하여 Instance를 생성해야 a 가 존재하는것이기 떄문
	public static int b;	//Class Member Field / 정적변수 > main이 생성된 후 끝날때까지 자리를 유지하기 때문
	
	// temp Instance 와 a 는 함께 생성
	// static 변수는 main이 시작되자마자 RAM의 data영역에 생성 
	// static class Member Field는 하나만 존재. a는 instance별로 생성 가능(Exam_04 > t1,t2,t3...)
	
	//static 
	
	public void func1() {
		//non static의 func1을 call 할시 Temp instance가 생성되기때문에 a변수도 생성. b는 항상 있기에 둘 다 사용가능
	}
	public static void func2() {
		//a = 1; static이 있는건 언제어디서든 사용할 수 있으나 a라는 변수는 메모리상에 항상존재하지않기 때문에 오류가 난다. 
		// static 요소에서 non-static 요소를 사용할 수 없다.
	}
	
}

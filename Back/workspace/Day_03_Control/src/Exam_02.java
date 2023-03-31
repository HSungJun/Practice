//반복문 > 사용자가 원하는 만큼의 명령을 여러번 실행
//특정 조건이 만족되는 동안 명령을 계속적으로 실행
//While 단독적인 제어문
//자바의 경우 while(조건문(무조건 true or false)) {실행문}
//식이 참일경우에만 루프처리를 반복한다. (중괄호의 끝이 남과 동시에 중괄호(조건문)으로 이동)

//stack <int 값을 저장.  
//data 
//heap 
//text 
//의 순으로 램은 이루어져있음


public class Exam_02 {
	public static void main(String[] args) {
		
		int i = 49; //초기값 지정. 미지정시 에러 발생
		while (i<100) {//조건문
			i++; // 증감문
			if(i%2==1) { 
			System.out.println("i=" +i);
		} 			
		
	}
	}
}
//		int i = 49; 
//		while (i<99) 
//			i+=2; //2씩 증가하지만 100에서는 101이 출력 > 한계치를 99로 만들면 동일한 값 출력
//			if(i%2==1) { 
//			System.out.println("i=" +i);
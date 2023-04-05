/* 배열 - 동일한 타입을 가진 변수들의 집합
		여러개의 변수를 한번에 선언 가능
		같은 형의 변수들을 연속적으로 쓸 수 있다.
		
DataType [] 배열이름;

변수 - 기본형(데이터 저장) 8개(적은 데이터, 크기 고정(stack memory)), 
	그외 참조형(주소값 저장)


메모리 영역 4가지/ 
stack 작고 고정된 데이터
data
heap 가변적, 큰데이터
text

*/
public class Exam_01 {
	public static void main(String[] args) {
		
//		나는 heap 메모리를 사용한다 >> new
		int[] arr = new int [] {10,20,30,40};
/*(heap 메모리에 만들어진 주소값을 int[]이라는 곳 arr로 저장한다)
int []arr = 생성된 16비트 공간(new int[4];)의 주소를 저장하는 참조변수(int[] arr)
 배열 생성 문법 : int형 변수 4개 생성 4byte 4개
16바이트 짜리 공간 생성
 
int[] 자체가 in, double, char 등과 같은 자료형
string[] 등 존재		
		
(Scanner sc = new Scanner(System.in); 의 new 도 heap 메모리에 저장)

String str = new "Hello world" 참조변수로서 heap 메모리에 저장하기 때문에 
											new를 사용해야하지만 생략 가능
		
		
arr[0],arr[1],arr[2],arr[3]  >> []내 첨자 또는 Index 라고 명명
		시작은 0 부터 > index = offset으로 시작접에서부터 얼마나 떨어져 있는가
		
arr[0] > "arr에 저장된 주소값에서 0만큼 떨어진 지점" 으로 해석
		
arr의 자료형은 int[] 배열
		*/
		
//		arr[0] = 10; // > arr[0]의 자료형은 int 
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
		
		//int[] arr = new int [] {10,20,30,40};
		//로 쓸때에는 [] 안의 값을 제거.
		
		
		
//		System.out.println(arr); // arr[1-1], arr[3/2] 등의 식으로도 표현 가능
//		System.out.println(arr[0]); // arr[(int)(Math.random())*3];
//		System.out.println(arr[1]); // arr[Integer.parseInt(sc.nextLine())];
//		System.out.println(arr[2]); // arr[a]
//		System.out.println(arr[3]); // 궁극적으로 숫자만 표현이 가능하면 가능
		
		
			int a = 0;
			
			for (a=0; a<=arr.length; a++) { // 이름.length 길이표현. 
				System.out.println(arr[a]);
			}
		
			
		
		
		
		
		
	}
}

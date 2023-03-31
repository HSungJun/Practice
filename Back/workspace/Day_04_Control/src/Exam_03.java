
public class Exam_03 {
	public static void main(String[] args) {
		
		int i;
		
		for(i=1; i<=10; i++) {
			if(i==2||i==5) { continue;
			}
			System.out.println("i=" + i);
			if(i==8) {
				break;
			}
		}
	}
}
// 2,5는 생략 > 8을 출력하고 종료
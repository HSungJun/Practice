import java.util.Scanner;

// 입력 Buffer? > 메모리 공간중 하나


//코드에 문자열 입력이 필요한 경우 sc.nexLine(); 필요 > String에 입력


public class Exam_07 {
	public static void main(String[] args) {
		
		//문장을 입력받는 기능
		Scanner sc = new Scanner(System.in); // Ctrl + shift + O(ㅐ)
		
		// System.in.read();은 단어를 받아오는 기능
		// sc.nextLine(); 은 String 값을 받아오는 기능
		System.out.println("<메세지를 남겨주세요.>");
		String str = sc.nextLine(); //아직 정해지지 않은 문자열 하나
		//System.out.println(str);
		
		System.out.println("<당신이 남긴 메세지는>");
		System.out.println(str);
		
		
		
	}
}

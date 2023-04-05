import java.util.Scanner;

public class Quiz_01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("오늘의 점심메뉴 - 주소를 알려드려요. ");
		System.out.println("1.김치찜 2.중국집 3.쭈꾸미");
		int menu = Integer.parseInt(sc.nextLine());
		
		if (menu==1 || menu ==2 || menu==3) {
			if (menu==1) {
				System.out.println("종로도담-서울 종로구 삼봉로 78");
			}else if (menu ==2) {
				System.out.println("원흥-서울 중구 다동길 46 ");
			}else if (menu ==3) {
				System.out.println("차돌박힌 쭈꾸미-서울 종로구 삼일대로17길 47-1");
			}else {System.out.println("메뉴를 다시 골라주세요.");
				
			}
		}	
	}
}

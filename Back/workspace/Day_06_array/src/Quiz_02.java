import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {

	

		String names = "";
		int lang = 0;
		int engl = 0;
		int sum;
		int avg;

		Scanner sc = new Scanner(System.in);

		String[] name = new String[3];
		int[] lan = new int[3];
		int[] eng = new int[3];
		while(true) {
		for(int ti=0; ti<lan.length; ti++) {
			System.out.println( (ti+1) +"��° �л��� �̸� : ");
			names = sc.nextLine();
			System.out.println(names+"�л� �������� :");
			lan[lang] = Integer.parseInt(sc.nextLine());				
			System.out.println(names+"�л� �������� :");
			eng[engl] = Integer.parseInt(sc.nextLine());
			
		}
		

		}


	}
}

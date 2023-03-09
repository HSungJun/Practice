import java.util.Scanner;

public class Quiz_A02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		String[] names = new String[3];
		int[] kors = new int[3];
		int[] engs = new int[3];
		
		
		for(int i = 0; i<3; i++) {
		System.out.print((i+1)+ " 번째 학생의 이름 : ");
		names[i] = sc. nextLine();
		
		System.out.print(names[0]+" 학생의 국어 : ");
		kors[i] = Integer.parseInt(sc. nextLine());
		
		System.out.print(names[0]+ " 학생의 영어 : ");
		engs[i] = Integer.parseInt(sc. nextLine());
		
		
		}
		System.out.println("이름\t국어\t영어\t평균\t합계");
		for(int i =0; i<3; i++) {
		System.out.println(names[i]+ "\t" + kors[i] + "\t "+ engs[i]
				+ "\t" + (kors[i]+engs[i])+ "\t" + (kors[i]+engs[i])/2.0);
		}
	}
}

import java.util.Scanner;

public class Quiz_A02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		String[] names = new String[3];
		int[] kors = new int[3];
		int[] engs = new int[3];
		
		
		for(int i = 0; i<3; i++) {
		System.out.print((i+1)+ " ��° �л��� �̸� : ");
		names[i] = sc. nextLine();
		
		System.out.print(names[0]+" �л��� ���� : ");
		kors[i] = Integer.parseInt(sc. nextLine());
		
		System.out.print(names[0]+ " �л��� ���� : ");
		engs[i] = Integer.parseInt(sc. nextLine());
		
		
		}
		System.out.println("�̸�\t����\t����\t���\t�հ�");
		for(int i =0; i<3; i++) {
		System.out.println(names[i]+ "\t" + kors[i] + "\t "+ engs[i]
				+ "\t" + (kors[i]+engs[i])+ "\t" + (kors[i]+engs[i])/2.0);
		}
	}
}

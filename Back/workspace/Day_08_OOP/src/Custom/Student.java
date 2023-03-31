package Custom;
import java.util.Scanner;

public class Student {

	// Constructor ������. 
	//�� ������� �ν��Ͻ��� �ʱⰪ�� �����ϱ� ���� �������� ���Ǵ� �޼��� 
	//�� �������� �޼��� �̸��� Ŭ������ �̸��� �����ؾ� �Ѵ�.
	//�� ������ �ż���� �ٸ� �ż��� ��� �ٸ��� return���� ���� �� ����.
	//�� ������ �ż���� �ٸ� �޼����� �ٸ��� method call Ÿ�̹��� ������ �� ����.
	//��Ÿ Ư���� �Ϲ� �޼���� �����ϴ�.
	
	//�����ڴ� ������ �ʾҾ ������ �����ϰ����� ������ ����.
//	Student(){} 
	//�⺻ ������ default constructor
	//�������� ����� �����ڿ� ���� ��������.
	
	private String name;
	private int korean;
	private int english;
	private int math;
	private int sum;
	private double avg;
	
	//�� void �� ���� �����ڰ� �ƴ�
	public Student (){
		// Ŭ�������� �ν��Ͻ��� ������ ���� ������ �޼��尡 �ݵ�.
	
		//Student check �� 
//		per.setName("Jack");
//		per.setKorean(95);
//		per.setEnglish(84);
//		per.setMath(68);
		//���� ����. 
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ���.");
		name = sc.nextLine();
		System.out.print("���������� �Է��ϼ���.");
		korean = Integer.parseInt(sc.nextLine());
		System.out.print("���������� �Է��ϼ���.");
		english = Integer.parseInt(sc.nextLine());;
		System.out.print("���������� �Է��ϼ���.");
		math = Integer.parseInt(sc.nextLine());;
		System.out.println();
	}
	
	
	
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		if(this.korean>0 || this.korean <=100) {this.korean = korean;
		}
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		if(this.english>0 || this.english <=100) {this.english = english;
		}
	}	
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		if(this.math>0 || this.math <=100) {this.math = math;
		}
	}
	
	public int getSum() {
		sum = (math+korean+english);
		return sum;
	}

	public double getAvg() {
		avg = ((sum)/3.0);
		return avg;
	}
	
	

	
	

}

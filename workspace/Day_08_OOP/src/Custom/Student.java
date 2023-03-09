package Custom;
import java.util.Scanner;

public class Student {

	// Constructor 생성자. 
	//★ 만들어진 인스턴스에 초기값을 세팅하기 위한 목적으로 사용되는 메서드 
	//★ 생성자의 메서드 이름은 클래스의 이름과 동일해야 한다.
	//★ 생성자 매서드는 다른 매서드 들과 다르게 return값을 가질 수 없다.
	//★ 생성자 매서드는 다른 메서드들과 다르게 method call 타이밍을 선택할 수 없다.
	//기타 특성은 일반 메서드와 동일하다.
	
	//생성자는 만들지 않았어도 무조건 존재하고있음 숨겨져 있음.
//	Student(){} 
	//기본 생성자 default constructor
	//개발자의 명시적 생성자에 의해 지워진다.
	
	private String name;
	private int korean;
	private int english;
	private int math;
	private int sum;
	private double avg;
	
	//★ void 를 쓰면 생성자가 아님
	public Student (){
		// 클래스바탕 인스턴스가 생성될 때에 생성자 메서드가 콜됨.
	
		//Student check 의 
//		per.setName("Jack");
//		per.setKorean(95);
//		per.setEnglish(84);
//		per.setMath(68);
		//값과 같다. 
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요.");
		name = sc.nextLine();
		System.out.print("국어점수를 입력하세요.");
		korean = Integer.parseInt(sc.nextLine());
		System.out.print("영어점수를 입력하세요.");
		english = Integer.parseInt(sc.nextLine());;
		System.out.print("수학점수를 입력하세요.");
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

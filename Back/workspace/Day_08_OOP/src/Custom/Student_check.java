package Custom;
public class Student_check {
	

	public static void main(String[] args) {
		
		//new 옆에는 항상 생성자가 있어야 함
		
		Student per = new Student();
//		per.setName("Jack");
//		per.setKorean(95);
//		per.setEnglish(84);
//		per.setMath(68);
		
//		System.out.println((per.getName()) +" / 국어 : "
//							+ (per.getKorean()) + ", 영어 :"
//							+ (per.getEnglish()) + ",  수학 :"
//							+ (per.getMath()));
		System.out.println("합계 : " +(per.getSum()) +" , "+
							" 평균 : "+ (per.getAvg()));
//		
//		System.out.println();
//		
//		
		Student std = new Student();
//		std.setName("Jane");
//		std.setKorean(100);
//		std.setEnglish(50);
//		std.setMath(95);
		
//		System.out.println((std.getName()) +" / 국어 :"
//				+ (std.getKorean()) + ", 영어 :"
//				+ (std.getEnglish()) + ", 수학 :"
//				+ (std.getMath()));
System.out.println("합계 : " +(std.getSum()) +" , "+
				" 평균 : "+ (std.getAvg()));
		
		
		
		
	}
}

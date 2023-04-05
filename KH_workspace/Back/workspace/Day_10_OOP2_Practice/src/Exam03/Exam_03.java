package Exam03;

public class Exam_03 {
	public static void main(String[] args) {
		
		//Contact Class 이름 전화번호 메일 ge,setter, 정보은닉 
		
		Contact H = new Contact("홍길동", "01012344321","hong@naver.com");
		
		Contact J = new Contact("조성태", "01090062139", "stj@gmail.com");
		
		System.out.println("이름 : " + H.getName()
		+"\t" + " 전화번호 : " + H.getPhone()
		+"\t" +" 이메일 : " + H.getEmail());
		
		System.out.println("이름 : " + J.getName()
		+"\t" + " 전화번호 : " + J.getPhone()
		+"\t" +" 이메일 : " + J.getEmail());
		
	}
}

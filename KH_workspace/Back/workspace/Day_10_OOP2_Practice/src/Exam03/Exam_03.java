package Exam03;

public class Exam_03 {
	public static void main(String[] args) {
		
		//Contact Class �̸� ��ȭ��ȣ ���� ge,setter, �������� 
		
		Contact H = new Contact("ȫ�浿", "01012344321","hong@naver.com");
		
		Contact J = new Contact("������", "01090062139", "stj@gmail.com");
		
		System.out.println("�̸� : " + H.getName()
		+"\t" + " ��ȭ��ȣ : " + H.getPhone()
		+"\t" +" �̸��� : " + H.getEmail());
		
		System.out.println("�̸� : " + J.getName()
		+"\t" + " ��ȭ��ȣ : " + J.getPhone()
		+"\t" +" �̸��� : " + J.getEmail());
		
	}
}


public class Test_Member {
	public static void main(String[] args) {
		
		Member m = new Member("ȫ�浿",25,"����� ��������","����");
//		Member m = new Member();
//		m.setName("ȫ�浿");
//		m.setAge(25);
//		m.setAdress("����� ��������");
//		m.setHobby("����");
		
		System.out.println("�̸� : "+ m.getName());
		System.out.println("���� : "+ m.getAge());
		System.out.println("�ּ� : "+ m.getAdress());
		System.out.println("��� : "+ m.getHobby());
		
	}
}

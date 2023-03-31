
public class Test_Member {
	public static void main(String[] args) {
		
		Member m = new Member("홍길동",25,"서울시 영등포구","독서");
//		Member m = new Member();
//		m.setName("홍길동");
//		m.setAge(25);
//		m.setAdress("서울시 영등포구");
//		m.setHobby("독서");
		
		System.out.println("이름 : "+ m.getName());
		System.out.println("나이 : "+ m.getAge());
		System.out.println("주소 : "+ m.getAdress());
		System.out.println("취미 : "+ m.getHobby());
		
	}
}

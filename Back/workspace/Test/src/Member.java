
public class Member {
	private String name;
	private int age;
	private String adress;
	private String hobby;
	
	public Member(String name,int age, String adress, String hobby) {
/*
	Member 객체 생성시 기본 생성자를 이용하여 생성하려고 하는데 매개변수가 있는 생성자를 작성했기 때문에
	객체 생성이 불가능하다.	
		
		기본생성자 public Member(){}
		Member = 객체
		(String name,int age, String adress, String hobby) = 매개변수
		
		
*/	
		this.name = name;
		this.age = age;
		this.adress = adress;
		this.hobby = hobby;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}

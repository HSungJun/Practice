
public class Member {
	private String name;
	private int age;
	private String adress;
	private String hobby;
	
	public Member(String name,int age, String adress, String hobby) {
/*
	Member ��ü ������ �⺻ �����ڸ� �̿��Ͽ� �����Ϸ��� �ϴµ� �Ű������� �ִ� �����ڸ� �ۼ��߱� ������
	��ü ������ �Ұ����ϴ�.	
		
		�⺻������ public Member(){}
		Member = ��ü
		(String name,int age, String adress, String hobby) = �Ű�����
		
		
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

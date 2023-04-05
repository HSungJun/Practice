package Classes;

	abstract public class Member {
	//abstract 메서드를 가진 경우 클래스 또한 abstract 를 가지도록 한다.(추상메서드, 추상클래스)
		
	
		
		
	private int id;
	private String name;
	private double point;

	public Member(int id, String name, double point) {
		this.id=id;
		this.name=name;
		this.point=point;
	}
	
	
	
	
	abstract public double getBonus();
	
	public void setBonus(double bonus) {
		this.point = bonus;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	
}

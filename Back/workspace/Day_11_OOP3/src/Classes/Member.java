package Classes;

	abstract public class Member {
	//abstract �޼��带 ���� ��� Ŭ���� ���� abstract �� �������� �Ѵ�.(�߻�޼���, �߻�Ŭ����)
		
	
		
		
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

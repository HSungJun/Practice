package Classes;

public class Gold extends Member{

public Gold(int id, String name, double point) {
		
		super(id,name,point);
		//super �� Member Ŭ������ ����Ʈ ����Ʈ���͸� ȣ���ϴ°��̳� ����� �����ڸ� �Է��߱⶧���� super�� �����ڸ� �θ��� ���� Gold���� �������߻�
		
	}
	
	public double getBonus() {
		return this.getPoint() *0.04;
		//���������� private �� �����ֱ� ������ getter�� �̿��Ͽ� �����´�
	}
	
}
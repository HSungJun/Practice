package Classes;

public class Ruby extends Member{

	public Ruby(int id, String name, double point) {
		
		super(id,name,point);
		//super �� Member Ŭ������ ����Ʈ ����Ʈ���͸� ȣ���ϴ°��̳� ����� �����ڸ� �Է��߱⶧���� super�� �����ڸ� �θ��� ���� Gold���� �������߻�
		
	}
	
	public double getBonus() {
		return this.getPoint() *0.05;
		//���������� private �� �����ֱ� ������ getter�� �̿��Ͽ� �����´�
	}
	
}

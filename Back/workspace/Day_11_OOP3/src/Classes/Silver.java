package Classes;
public class Silver extends Member {

	public Silver(int id, String name, double point) {
		
		super(id,name,point);
		//super �� Member Ŭ������ ����Ʈ ����Ʈ���͸� ȣ���ϴ°��̳� ����� �����ڸ� �Է��߱⶧���� super�� �����ڸ� �θ��� ���� Gold���� �������߻�
		
	}
	
	public double getBonus() {
		return this.getPoint() *0.02;
		//���������� private �� �����ֱ� ������ getter�� �̿��Ͽ� �����´�
	}
	//����Ŭ�����κ��� ��ӹ��� �޼��带 �����ϰ� �ٽ� ������ ������ Ÿ������ �ٽ� ������ ��� ��ӹ��� �޼��带 ���� ����� ȿ���� ������.
	//override - ��ȿȭ ��Ű��. �θ�Ŭ�������� ��ӹް� �����ؼ� ����� �ÿ� ��Ÿ���� ��
	//overload�ʹ� �ٸ� (������ �̸��� �޼ҵ带 �޴� �Ķ���͸� �ٲ㼭 �ۼ��ϴ°�)
	// call, call("String") ���� ������ ȣ���̳� �޴� ��ĸ� �ٲٴ� ��
	
	
}

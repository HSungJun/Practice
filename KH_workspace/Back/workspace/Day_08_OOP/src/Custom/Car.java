package Custom;

public class Car {
	
	//������. ����Ű alt ����ä�� srar or alt shift s r
	
	private String vendor;  // ���ϸ��̳� stack �޸𸮿� ����	
	private String model;
	private String color;
	private int price;
	
	
	
	
	
	public String getVendor() {
		return vendor;
	}									// ����ʵ� �Ű����� ���� �Ȱ�.
	public void setVendor(String vendor) { //new�� ������ ���̱� ������ heap �Ÿ𸮿� ���� 
		this.vendor = vendor;				// �� vendor �ʹ� �ٸ����� �����ϱ� ������ �ߺ�����
	}
	//this(�ڱ����� ����)�� �߰�{member field} 
	//Car Ŭ���� ���ο����� Instance �ּҸ� �� �� ���⶧���� �̸� �˼��ְ� this�� �ܺο��� ���� Instance �ּҿ� ����.
	//Ŭ������ �������� �ν��Ͻ��� �����Ǹ�, Ŭ���� ���ο��� �ν��Ͻ� �ּҸ� �� �� �ְ�
	//�ڹٿ� ���� �̸� �غ�� ����ʵ� / �Ϲ��� ����-�������� ������ ��������ִ�.
	
	//this�� ����ʵ�� �Ű������� ���� �� �� ���� ex) Car_check���� car. �� Car Ŭ�������� this.�� �����ϰ�
	//����ʵ尡 ��Ÿ��(private�� �ƴҰ�� Ȯ�ΰ�)

	
	
	
	
	public Car getThis() {
		return this;
	}
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if (price >0) {this.price = price;
		}
	}
	
	
}

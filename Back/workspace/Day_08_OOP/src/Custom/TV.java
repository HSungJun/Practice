package Custom;
//Ŭ������ ���� ����� �� (�ǰ���������� ���� ����丸)
//	�������� - ���������ڿ� ���� [ public, protected, package, private ]
// public - ���µ� ���·� ������Ʈ ���ο��� ���氡�� 
// private - public�� ���ݴ�. �ܺο��� ���� ���� 
// TV ä�ΰ������ ������ �� ������ ������ ���� �������� ��ɻ� ������ �߻��� �� �ֱ⶧�� > private
// �ܺγ����� �ʿ���� ������ private�� ���� 
// Ŭ���� �������� �ǵ���� �������� Ŭ������ ����� �����ϰ� ����� ���
// Ŭ���� �����ڿ��� �������� ������ �� ����
// Ŭ���� ������� ���Ǽ����� ������ ��ħ

//package �� ���� ���� - Ŭ������ �з��ϴ� ������ ���� (����)


public class TV {
	private String brand;
	private int price;
	private int weight;
	private int channel ;
	// ���赵���� �Ӽ��� �����ϴ� ���� - ������� (Member Field)
	// >> Method ���ο� ������ stack�� ����. �׷��� class�� ������ heap �� Instance �� ����

	
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return brand;
	}
	
	
	public void setPrice(int price) {
		if (price>0) {
		this.price = price;
		}
	}
	public int getPrice(int pri) {
		return price;
		}
	
	
	public void setWeight(int weight) {
		if (weight>0) {
		this.weight = weight;
		}
	}	
	public int getWeight() {
		return weight;
		
		
	}

	
	public void setChannel(int cha) {
		if (cha>0) {
			channel = cha;
		}
	}// ä���� ���� �����ؼ� ���� x �޼��带 ���ؼ� ä�� ����
		//��������� private�� ����� �޼��带 ���� ������ �� �ֵ��� ����� ���� Ŭ����(instance�� 
		// ����Ʈ���� �ʰ� ��� ����)
	// ä�� ���� > �ܺο��� ���η� ���� > ���ϰ� �ʿ�x void �Ű����� o

	public int getChannel() {
		return channel;
	}
	// ���� ������ ä���� ���ο��� �ܺη� ���������� > ���ϰ� �ʿ�o �Ű����� x
	// ä���� ��� �����̱� ������ int 
	
	// ����> �ܺ� get / �ܺ� > ���� set (Ŭ���� ����� ���ǹ�������)(setter, getter)
	

	void powerON() {
		price = 100;
	}

	void powerOFF() {}
	//Ŭ������ �����ϴ� �޼��� - ��� �޼��� (Member Method)




	//Nested Class 
	//Constructor




}

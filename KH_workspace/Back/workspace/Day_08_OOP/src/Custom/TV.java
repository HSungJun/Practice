package Custom;
//클래스를 좋게 만드는 법 (권고사항이지만 추후 변경요만)
//	정보은닉 - 접근제한자와 연관 [ public, protected, package, private ]
// public - 오픈된 상태로 프로젝트 내부에서 변경가능 
// private - public과 정반대. 외부에서 접근 차단 
// TV 채널같은경우 조작할 수 있지만 제한이 있음 음수등의 기능상 문제가 발생할 수 있기때문 > private
// 외부노출이 필요없는 정보를 private로 가려 
// 클래스 설계자의 의도대로 안정적인 클래스를 운용이 가능하게 만드는 방식
// 클래스 설계자에게 안정성을 제공할 수 있음
// 클래스 사용자의 편의성에도 영향을 미침

//package 는 폴더 개념 - 클래스를 분류하는 폴더의 역할 (단위)


public class TV {
	private String brand;
	private int price;
	private int weight;
	private int channel ;
	// 설계도에서 속성을 저장하는 변수 - 멤버변수 (Member Field)
	// >> Method 내부에 변수는 stack에 저장. 그러나 class에 변수는 heap 의 Instance 에 저장

	
	
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
	}// 채널을 직접 접근해서 조작 x 메서드를 통해서 채널 조작
		//멤버변수를 private로 만들고 메서드를 통해 조작할 수 있도록 만드는 것이 클래스(instance를 
		// 망가트리지 않고 사용 가능)
	// 채널 조작 > 외부에서 내부로 조작 > 리턴값 필요x void 매개변수 o

	public int getChannel() {
		return channel;
	}
	// 내부 정보인 채널을 내부에서 외부로 내보내야함 > 리턴값 필요o 매개변수 x
	// 채널의 경우 숫자이기 때문에 int 
	
	// 내부> 외부 get / 외부 > 내부 set (클래스 설계시 반의무적생성)(setter, getter)
	

	void powerON() {
		price = 100;
	}

	void powerOFF() {}
	//클래스를 구성하는 메서드 - 멤버 메서드 (Member Method)




	//Nested Class 
	//Constructor




}

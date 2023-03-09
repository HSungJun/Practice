package Custom;

public class Car {
	
	//컨벤션. 단축키 alt 누른채로 srar or alt shift s r
	
	private String vendor;  // 동일명이나 stack 메모리에 저장	
	private String model;
	private String color;
	private int price;
	
	
	
	
	
	public String getVendor() {
		return vendor;
	}									// 멤버필드 매개변수 구분 안감.
	public void setVendor(String vendor) { //new로 생성된 것이기 떄문에 heap 매모리에 저장 
		this.vendor = vendor;				// 위 vendor 와는 다른곳에 저장하기 때문에 중복가능
	}
	//this(자기참조 변수)를 추가{member field} 
	//Car 클래스 내부에서는 Instance 주소를 알 수 없기때문에 이를 알수있게 this가 외부에서 보는 Instance 주소와 같다.
	//클래스를 바탕으로 인스턴스가 생성되면, 클래스 내부에서 인스턴스 주소를 알 수 있게
	//자바에 의해 미리 준비된 멤버필드 / 암묵적 문법-만든적은 없지만 만들어져있다.
	
	//this는 멤버필드와 매개변수를 구분 할 수 있음 ex) Car_check에서 car. 과 Car 클래스에서 this.은 동일하게
	//멤버필드가 나타남(private이 아닐경우 확인가)

	
	
	
	
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

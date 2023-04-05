package Classes;

public class Gold extends Member{

public Gold(int id, String name, double point) {
		
		super(id,name,point);
		//super 는 Member 클래스의 디폴트 컨스트럭터를 호출하는것이나 멤버에 생성자를 입력했기때문에 super가 생성자를 부를수 없어 Gold에서 오류가발생
		
	}
	
	public double getBonus() {
		return this.getPoint() *0.04;
		//접근제한자 private 에 막혀있기 때문에 getter를 이용하여 가져온다
	}
	
}
package Classes;
public class Silver extends Member {

	public Silver(int id, String name, double point) {
		
		super(id,name,point);
		//super 는 Member 클래스의 디폴트 컨스트럭터를 호출하는것이나 멤버에 생성자를 입력했기때문에 super가 생성자를 부를수 없어 Gold에서 오류가발생
		
	}
	
	public double getBonus() {
		return this.getPoint() *0.02;
		//접근제한자 private 에 막혀있기 때문에 getter를 이용하여 가져온다
	}
	//보무클래스로부터 상속받은 메서드를 무시하고 다시 동일한 프로토 타입으로 다시 정의할 경우 상속받은 메서드를 덮어 씌우는 효과를 가진다.
	//override - 무효화 시키다. 부모클래스에게 상속받고 변경해서 사용할 시에 나타나는 것
	//overload와는 다름 (동일한 이름의 메소드를 받는 파라미터만 바꿔서 작성하는것)
	// call, call("String") 등의 동일한 호출이나 받는 방식만 바꾸는 것
	
	
}

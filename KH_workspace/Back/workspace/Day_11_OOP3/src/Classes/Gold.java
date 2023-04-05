package Classes;
	public class Gold extends Member { //Gold는 Member 클래스를 확장한다 - 상속
		
		public Gold(int id, String name, double point) {
			super(id,name,point);
		}

		
		public double getBonus() {
			return this.getPoint() *0.04;
		}
		// abstract 또한 상속이 되므로 부모클래스에서 추상처리한 메서드를 자식클래스에서 동일한 메서드의 조건을 입력해주어야한다.
		
}

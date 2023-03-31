package Classes;

public class Silver extends Member{

		public Silver(int id, String name, double point) {
			super(id,name,point);
		}
	
		
		public double getBonus() {
			return this.getPoint() *0.02;
		}
}

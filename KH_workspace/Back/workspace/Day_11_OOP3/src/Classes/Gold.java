package Classes;
	public class Gold extends Member { //Gold�� Member Ŭ������ Ȯ���Ѵ� - ���
		
		public Gold(int id, String name, double point) {
			super(id,name,point);
		}

		
		public double getBonus() {
			return this.getPoint() *0.04;
		}
		// abstract ���� ����� �ǹǷ� �θ�Ŭ�������� �߻�ó���� �޼��带 �ڽ�Ŭ�������� ������ �޼����� ������ �Է����־���Ѵ�.
		
}

package Exam02;

public class Manager {
	private CafeMenu[] cafe = new CafeMenu[100];
	private int index = 0;
	
	public void addMenu(CafeMenu cafemenu) {
		this.cafe[index++] = cafemenu;
	}
	
	public CafeMenu[] getMenu() {
		return this.cafe;
	}
	
	public int getIndex() {
		return index;
	}
	
}

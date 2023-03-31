package Exam02_ArrayList;

import java.util.ArrayList;

public class Manager {
	private ArrayList<CafeMenu> menus = new ArrayList<>();

	public void addMenu(CafeMenu menu) {
		this.menus.add(menu);
	}

	public ArrayList<CafeMenu> getMenu() {
		return this.menus;
	}

	public ArrayList<CafeMenu> searchByNum(int num) {
		ArrayList<CafeMenu> result = new ArrayList<>();
		for (CafeMenu menu : menus) {
			if (num == menu.getNum()) {
				result.add(menu);
			}
		}
		return result;
	}

	
	
	
	
	public void updateByNum(int num, CafeMenu upMenu) {
		for (CafeMenu menu : menus) {
			if (menu.getNum() == num) {
				menu.setNum(upMenu.getNum());
				menu.setName(upMenu.getName());
				menu.setPrice(upMenu.getPrice());

			}
		}

	}

}
